//73. Set Matrix Zeroes
//projection and mark zero position in number 1 (other than 0)
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0) return;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j]==0){
                    row[i] = 1;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[j][i]==0){
                    col[i] = 1;
                }
            }
        }
        for(int i = 0;i<m;i++){
            if(row[i]==1)
            for(int j = 0;j<n;j++){
                matrix[i][j] = 0;
            }
        }
        for(int i = 0;i<n;i++){
            if(col[i]==1)
            for(int j = 0;j<m;j++){
                matrix[j][i] = 0;
            }
        }
        
    }
}