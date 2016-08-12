Triangle

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Notice

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

Example
Given the following triangle:

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
---------------------------------------------------------------------------------------------------
public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0){
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        int m = triangle.length;
        int[][] dp = new int[m][m];
        
        for(int i = 0;i<m;i++){
            dp[m - 1][i] = triangle[m - 1][i];
        }
        for(int i = m - 2; i >= 0; i--){
            for(int j = 0;j <= i; j++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}
