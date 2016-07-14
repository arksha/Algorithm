// 336. Palindrome Pairs.java

// Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

// Example 1:
// Given words = ["bat", "tab", "cat"]
// Return [[0, 1], [1, 0]]
// The palindromes are ["battab", "tabbat"]
// Example 2:
// Given words = ["abcd", "dcba", "lls", "s", "sssll"]
// Return [[0, 1], [1, 0], [3, 2], [2, 4]]
// The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

// ---------------------------------------------------------------------------------------------------------------------
// O(m * n ^ 2) 

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if(words==null||words.length==0) return res;
        //put all into hashmap
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i<words.length;i++){
            map.put(words[i],i);
        }
        //go through every words, check is palindrome
        for(int i = 0;i<words.length;i++){
            String s = words[i];
            List<Integer> list;
            //if the words is palindrome, find "" in the map
            if(ispalindrome(s)){
                if(map.containsKey("")&&map.get("")!=i){
                    list = new ArrayList<>();
                    list.add(i);
                    list.add(map.get(""));
                    res.add(list);
                    
                    list = new ArrayList<>();
                    list.add(map.get(""));
                    list.add(i);
                    res.add(list);
                }
            }
            //if words reverse is in map, put into result
            String string= new StringBuilder(s).reverse().toString();
            if(map.containsKey(string) && map.get(string)!=i){// insure not repeat
                list = new ArrayList<>();
                list.add(i);
                list.add(map.get(string));
                res.add(list);
            }
            //else check left part and right part palindrome
            for(int centralinx = 1;centralinx<s.length();centralinx++){// don't know where is the central of palindrome so try every one as central
                String left = s.substring(0,centralinx);
                String right = s.substring(centralinx);
                if(ispalindrome(left)){
                    String reverseright = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reverseright)&& map.get(reverseright)!=i){
                        list = new ArrayList<>();
                        list.add(map.get(reverseright));
                        list.add(i);
                        res.add(list);
                    }
                }
                if(ispalindrome(right)){
                    String reverseleft = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(reverseleft) && map.get(reverseleft)!=i){
                        list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(reverseleft));
                        res.add(list);
                    }
                }
            }
        }//for
        return res;
    }
    //check string if is palindrome
    public boolean ispalindrome(String s){
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}