329. Longest Increasing Path in a Matrix.java
//dfs with dp memorization
//dp[i][j] record longest seq number start from i j
public class Solution {
    static final int[][] adj = {{1,0},{0,1},{-1,0},{0,-1}};//adj 
    public int longestIncreasingPath(int[][] matrix) {//dp memorization
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int res = 0;
        
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                res = Math.max(res,dfs(matrix,i,j,dp));
            }
        }
        return res;
    }
    public int dfs(int[][] matrix, int i,int j,int[][] dp){
        if(dp[i][j]!=0) return dp[i][j];
        
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 1;
        for(int a = 0;a < 4;a++){
                int x = i+adj[a][0];
                int y = j+adj[a][1];
                
                if(x<0||y<0||x>=n||y>=m||matrix[x][y]<=matrix[i][j]) continue;
                max = Math.max(dfs(matrix,x,y,dp)+1,max);
        }
        
        dp[i][j] = max;
        return max;
    }
}