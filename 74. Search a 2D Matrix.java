// 74. Search a 2D Matrix
// Write an efficient algorithm that searches for a value in an m x n matrix. 
// This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
//----------------------------------------------------------------------------------------------------------------

// think as a consecutive array and use binary search, find index of array and translate into matrix index.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int h = m*n-1;
        while(l<h){
            int mid = l+(h-l)/2;
            if(matrix[mid/n][mid%n]<target) l = mid+1;
            else h = mid;
        }
        return matrix[h/n][h%n]==target;
    }
}