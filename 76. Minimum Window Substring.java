// 76. Minimum Window Substring

// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".

// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".

// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

// ------------------------------------------------------------------------------------------------------------------------
// use hashmap and two pointers, similar template of solving substirng problem.
// hashmap is for counting whether substring is all included,
// two pointers i, j is to find a valid window and optimize it. 
// move j to find window, move i to find valid start of window.
// use a int count detect how many we have counted in the HashMap for now 

public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tmap = new HashMap<>();
        for(int i = 0;i<t.length();i++){
            if(!tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i),1);
            }else{
                tmap.put(t.charAt(i),tmap.get(t.charAt(i))+1);
            }
        }
        int index = 0;
        int minlen = Integer.MAX_VALUE;
        int count = 0;
        int i = 0;
        for(int j = 0;j<s.length();j++){
            char ch = s.charAt(j);
            if(tmap.containsKey(ch)){
                tmap.put(ch,tmap.get(ch)-1);
                if(tmap.get(ch)>=0)
                    count++;
                while(count == t.length()){
                    if(j-i+1<minlen){
                        index = i;
                        minlen = j-i+1;
                    }
                    if(tmap.containsKey(s.charAt(i))){
                        tmap.put(s.charAt(i),tmap.get(s.charAt(i))+1);
                        if(tmap.get(s.charAt(i))>0){
                            count--;
                        }     
                    }
                    i++;
                }
            }
        }
        return minlen> s.length() ? "": s.substring(index,index+minlen);
    }
}