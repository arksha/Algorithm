Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.

dp[i][j]: at i,j, the max square length of square 


public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int n = matrix.length;
        int m  = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for(int i = 0; i < n ; i++){
            dp[i][0] = matrix[i][0] -'0';
            max = Math.max(max, dp[i][0]);
        }
        for(int j = 0; j < m; j++){
            dp[0][j] = matrix[0][j] - '0';
            max = Math.max(max, dp[0][j]);
        }
        for(int i = 1; i < n ; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = matrix[i][j] == '1' ? Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1 : 0;
                max = Math.max(dp[i][j], max);
            }
        }
        return max * max;
    }
}
