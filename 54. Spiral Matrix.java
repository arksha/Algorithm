//54. Spiral Matrix
//
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0) 
            return res;
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;//i is number of circle
        while(i*2<n && i*2<m){
            for(int j = i;j<n-i;j++)
                res.add(matrix[i][j]);

            for(int j = i+1;j<m-i;j++){
                res.add(matrix[j][n-i-1]);
            }
            if(m-2*i==1||n-2*i==1) break;

            for(int j = n-i-2;j>=i;j--){
                res.add(matrix[m-i-1][j]);
            }

            for(int j = m-i-2;j>=i+1;j--){
                res.add(matrix[j][i]);
            }
            
            i++;
        }
        return res;
    }
}