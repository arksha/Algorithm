// 28. Implement strStr()

// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// search for a string position appears in other string.


public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()||haystack==null|| needle==null)return -1;
        if(haystack.length()==0&&needle.length()==0||needle.length()==0)return 0;
        for(int i = 0;i<=haystack.length()-needle.length();i++){
            String sub = haystack.substring(i,i+needle.length());
            if(sub.equals(needle)) return i;
        }
        return -1;
    }
}