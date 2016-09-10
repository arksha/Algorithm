392. Is Subsequence.java
        // ahbgdc t
        // axc    s
        // use two pointers , one of each string

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null && t == null || s.length() == 0){//corner case for s == 0
            return true;
        }   
        int is = 0;
        for(int i = 0; i < t.length(); i++){
            if(s.charAt(is) == t.charAt(i)){
                is++;
            }
            if(is == s.length()){
                return true;
            }
        }
        return false;
    }
}
