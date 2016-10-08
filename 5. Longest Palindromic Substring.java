// 5. Longest Palindromic Substring

// Given a string S, find the longest palindromic substring in S. 
//You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

----------------------------------------------------------------------------------------
expand substring length and check
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int strlen = 0;
        for(int i = 0;i<s.length();i++){
            if(ispalindrom(s,i-strlen-1,i)){
                res = s.substring(i-strlen-1,i+1);
                strlen +=2;
            }
            if(ispalindrom(s,i-strlen,i)){
                res = s.substring(i-strlen,i+1);
                strlen +=1;
            }
        }
        return res;
    }
    public boolean ispalindrom(String s, int l,int r){
        if(s==null||s.length()==0) return true;
        if(l<0) return false;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
-------------------------------------------------------------------------------------
Time O(n^2) space O(1)

public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        if(s.length() == 1){
            return s;
        }
        String result = s.substring(0,1);
        for(int i = 0; i < s.length(); i++){
            String cur = findPalindrome(s, i, i);// center with i palindrome O(n)
            if(cur.length() > result.length()){
                result = cur;
            }
            cur = findPalindrome(s, i, i + 1);
            if(cur.length() > result.length()){
                result = cur;
            }
        }
        return result;
    }
    private String findPalindrome(String s, int i, int j){// two pointers i go left ,j go right
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
}
