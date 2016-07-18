// 10. Regular Expression Matching


// Implement regular expression matching with support for '.' and '*'.

// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true

// ------------------------------------------------------------------------------------------------------------------
// recursion solution
// two string s, and p 
// two cases: 
// 1. p[i+1] is not "*"
// 2. p[i+1] is "*"

// end condition: reach to string p end
// match condition: two char are same or p=='.'
// for 1: if is not match, return false, else go to next status.
// for 2: check all match possible s[i] to s[end], recursivly

// NB: add validation to check the last char in s and p.
// 	for case 2, check two chars in p one time, step is 2.
// 	after checking case 1 and 2, remember return next status, is i,j+2.

public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s,p,0,0);
    }
    private boolean helper(String s, String p, int i, int j){
        if(j==p.length()) 
            return i==s.length();
        if(j ==p.length()-1||p.charAt(j+1)!='*'){
            if(i==s.length()|| s.charAt(i)!=p.charAt(j) && p.charAt(j)!='.'){
                return false;
            }else{
                return helper(s,p,i+1,j+1);
            }
        }
        while(i<s.length()&&(p.charAt(j)==s.charAt(i) || p.charAt(j)=='.')){
            if(helper(s,p,i,j+2))
                return true;
            i++;
        }
        return helper(s,p,i,j+2);
    }
}

// ------------------------------------------------------------------------------------------
// DP solution
// dp[i][j] for postion i in s, j in p is match or not.
// dp[0][0] both s and p is empty, true 
// dp[0][j] s is empty,if p[j-1] is not '*' dp[0][j]= false; if p[j-1]=='*', dp[0][j] = check [i][j-2] and [i-1][j] 
// dp[i][0] p is empty, p cannot be empty, all set as false

// dp[i][j]  = if(p[i-1]!='*'), check [i-1][j-1];
// 			if(p[i-1]=='*'), plus [i-1][j-2] and check[i-1][j]

// range [0,n][0,m]

// NB: dp[0][j] and dp[i][0] can combine into dp[i][j] since have to see p[i-1]=='*' anyway.
// 	careful i validation.
	
public class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i = 0;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(p.charAt(j-1)!='*'){
                    dp[i][j] = i>0 && dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.');
                }else{
                    dp[i][j] = dp[i][j-2] || i>0&& dp[i-1][j]&&(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.');
                }
            }
        }
        return dp[n][m];
    }
}