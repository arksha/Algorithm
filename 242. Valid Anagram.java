// 242. Valid Anagram.java

// HashMap key: alphabet, value: times appear of alphabet
//     add s into map, 
//     go though t to check if it is in s, 
//     remove the same one, 
//     check map size == 0 

public class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(s.length()!=t.length()) return false;
        for(int i = 0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
                
        }
        for(int i = 0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                if(map.get(t.charAt(i))!=1) 
                    map.put(t.charAt(i),map.get(t.charAt(i))-1);
                else
                    map.remove(t.charAt(i));
            }else return false;
        }
        if(map.size()==0) return true;
        else return false;
    }
}

// ------------------------------------------------------------------------------------------------------------
// quicker version: use array[26] to implement

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        if(s.length()!=t.length()) return false;
        for(int i = 0;i<s.length();i++){
            map[s.charAt(i)-'a']++;
            map[t.charAt(i)-'a']--;
        }
        for(int num: map){
            if(num!=0) return false; 
        }
        return true;
        
    }
}