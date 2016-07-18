//44. Wildcard Matching

// Implement wildcard pattern matching with support for '?' and '*'.

// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false
// -------------------------------------------------------------------------------------------------------------------
//1.use two pointers to go through strings
// pointer str in s, pointer patt in p
// pstar to show if p == '*'
// ms record the last matched postion for back track, if encounter p !='*' check back to this mark at s

// This is much faster than DP sol O(n)
public class Solution {
    public boolean isMatch(String s, String p) {//double pointers
        int str = 0;
        int patt = 0;
        int pstar = -1;
        int ms = 0;
        while(str<s.length()){
            //match
            if(patt<p.length()&&(s.charAt(str)==p.charAt(patt)||p.charAt(patt)=='?') ){
                str++;
                patt++;
            //p=='*', step pointer in p, record current s position for back track
            }else if(patt<p.length() && p.charAt(patt)=='*'){
                pstar = patt;
                ms = str;
                patt++;
            //p!='*', only step pointer in p, go back to last matched postion and update ms to next postion
            }else if(pstar!=-1){
                patt = pstar+1;
                ms++;
                str = ms;
            //no * at all
            }else{
                return false;
            }
            
        }
        //check for remain char in p
        while(patt<p.length() && p.charAt(patt)=='*'){
            patt++;
        }
        return patt==p.length();
    }
}
// -------------------------------------------------------------------------------------------------------------------
// DP solution same as  10. retular expression match 
// but so slow 
// need improve run time 
//O(n^2)  O(n^2)
public class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 0;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(p.charAt(j-1)!='*'){
                    dp[i][j] = i>0 && dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'); 
                }else {
                    dp[i][j] = dp[i][j-1] || i>0 && dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}