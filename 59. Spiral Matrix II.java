//59. Spiral Matrix II
//Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
// i - circle
// i~n-i-1, i~n-i-1, n-i-1~ i,n-i-1~i

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if(n==0) return res;
        int i = 0;
        int c = 1;
        while(i*2<n){
            for(int j = i;j<n-1-i;j++){
                res[i][j] = c;
                c++;
            }
            for(int j = i;j<n-1-i;j++){
                res[j][n-1-i] = c;
                c++;
            }
            for(int j = n-1-i;j>i;j--){
                res[n-1-i][j] = c;
                c++;
            }
            for(int j = n-1-i;j>i;j--){
                res[j][i] = c;
                c++;
            }
            if(n%2!=0) res[n/2][n/2] = c;
            i++;
        }
        return res;
    }
}