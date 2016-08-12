62. Unique Paths  
Difficulty: Medium
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Note: m and n will be at most 100.

---------------------------------------------------------------------------------------------------------------------------------
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m==0||n==0) return 1;
        int [][] res = new int[m][n];
        for(int i = 0;i<n;++i){
            res[0][i] = 1;
        }
        for(int i = 0;i<m;++i){
            res[i][0] = 1;
        }
        for(int i = 1;i<m;++i){
            for(int j = 1;j<n;++j){
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
}
---------------------------------------------------------------------------------------------------------------------------------
improvement with space
public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}

------------------
updated 8.12.16

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here 
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            dp[i][0] = 1; 
        }
        for(int i = 0;i<n;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n -1];
    }
}

