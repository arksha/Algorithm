64. Minimum Path Sum

//O(n^2) space
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];
        for(int i = 1;i<m;i++){
            res[i][0] = res[i-1][0] + grid[i][0]; 
        }
        for(int i = 1;i<n;i++){
            res[0][i] = res[0][i-1] + grid[0][i]; 
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                res[i][j] = Math.min(res[i-1][j],res[i][j-1]) + grid[i][j];
            }
        }
        return res[m-1][n-1];
    }
}

//in place

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i!=0&&j==0){
                    grid[i][j] += grid[i-1][j];
                }else if(i==0&&j!=0){
                    grid[i][j] += grid[i][j-1]; 
                }else if(i==0&&j==0){
                    grid[i][j] = grid[i][j];
                }else{
                    grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
                    
                }
            }
        }
        return grid[m-1][n-1];
    }
}
