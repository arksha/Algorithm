//48. Rotate Image

//O(n^2)
// 1,2,3  horizontal     7,8,9    diagonal    7,4,1
// 4,5,6    ->           4,5,6       ->       8,5,2
// 7,8,9                 1,2,3                9,6,3  
//------------------------------------------------------------------------------


public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null||matrix.length==0) return;
        int n = matrix.length;
        int[][] mat = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                mat[j][n-1-i] = matrix[i][j];
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                matrix[i][j] = mat[i][j];
            }
        }
    }
}


//-------------------------------------------------------------------------------
//OR no need to get new int[][] 
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0|| matrix[0].length==0) return;
        int n = matrix.length;
        for(int i = 0;i<n/2;i++){
            for(int j = 0;j<n;j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[n-1-i][j];
               matrix[n-1-i][j] = temp;
            }
        }
        
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }
    }
}


//-----------------------------------------------------------------------------
// in place
              
//      --->       i,j   --
//     |                  |
//                        v
// n-1-j,i                       

//     |               j,n-1-i
//                        |
//     n-1-i,n-1-j    <---
//------------------------------------------------------------------------------

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0|| matrix[0].length==0) return;
        int n = matrix.length;
        for(int i = 0;i<n/2;i++){
            for(int j = 0;j<(n+1)/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}