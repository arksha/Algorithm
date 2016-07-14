// 115. Distinct Subsequences

// Given a string S and a string T, count the number of distinct subsequences of T in S.

// A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

// Here is an example:
// S = "rabbbit", T = "rabbit"

// Return 3.

// ------------------------------------------------------------------------------------------------------------------------
// Description is not clear, 
// how many different ways we can get the subsequence of S to become T .

// Input:
// String s /*source string*/
// String t /*targer string*/

// Output:
// int /*number of ways to get subsequence in s to become t */ 

// dp[i][j]: at postion i in t, position j in s, defferent ways to get subsequence in s

// Base case: 
// dp[0][j] = 1; //because when t is null, s only has one way to change into t
// dp[i][0] = 0; //when s is empty, there is no way to have subsequence to change to t

// if character is same, should equals to last postion ways add with S last position ways,
// if not same, this position just equals to S last position ways.
// Formula:
// dp[i][j] = t[i-1]==s[j-1]? dp[i-1][j-1] + dp[i][j-1] : dp[i][j-1]

// i [0, tlength+1] , j [0, slength+1] fill the table

public class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0;i<n+1;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i<m+1;i++){
            for(int j = 1;j<n+1;j++){
                char ct = t.charAt(i-1);
                char cs = s.charAt(j-1);
                dp[i][j] = cs==ct? dp[i-1][j-1] + dp[i][j-1]: dp[i][j-1];     
            }
        }
        
        return dp[m][n];
    }
}