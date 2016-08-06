// 28. Implement strStr()

// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// search for a string position appears in other string.

// --------------------------------------------------------------------------------------------------------------
// a more preferable style of coding

public class Solution{
    public int strStr(String haystack, String needle){
        if (haystack == null || needle == null){
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++){
            int j = 0;
            for (j = 0; j < needle.length(); j++){
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == needle.length()){
                return i;
            }
        }
        return -1;
    }
}
// --------------------------------------------------------------------------------------------------------------
// Check if needle string is in the haystack string, return the first appear index.
// Is asking to implement indexOf( ) actually
// ------------------------------------------------------------------------------------------------------------
// use size of needle window, use substring() to check if substring in kaystack
// if equals, return current index
// 
// careful of loop end with equal to haystack - needle length 
// handle case of haystack is shorter than needle 
// handle empty stirng case
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()||haystack==null|| needle==null)
        	return -1;
        if(haystack.length()==0&&needle.length()==0||needle.length()==0)
        	return 0;
        for(int i = 0;i<=haystack.length()-needle.length();i++){
            String sub = haystack.substring(i,i+needle.length());
            if(sub.equals(needle)) return i;
        }
        return -1;
    }
}
// ------------------------------------------------------------------------------------------------------------
// not using any api method like substring
// replace substring implement
public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length()||haystack==null|| needle==null)return -1;
        if(haystack.length()==0&&needle.length()==0||needle.length()==0)return 0;
        for(int i = 0;i<=haystack.length()-needle.length();i++){
            int j;
            for(j = 0;j<needle.length();j++){
                if(haystack.charAt(i+j)!= needle.charAt(j))
                    break;
            }
            if(j==needle.length())
                return i;
        }
        return -1;
    }
}