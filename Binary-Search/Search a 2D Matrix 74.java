// 74. Search a 2D Matrix
// Write an efficient algorithm that searches for a value in an m x n matrix. 
// This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.


//----------------------------------------------------------------------------------------------------------------
// 1.do twice binary search, once for finding row, once for column
// 2.NB: because of (l+1<h), need to consider last two row, and have consider the row of h instead of l 
//     because if target > l maybe also >h, in this case target will be in row h. 
// 3. can reuse l and h variable
public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }
        if(matrix[0] == null || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        
        int l = 0, h = row-1;
        while(l + 1 < h){
            int rowm = l + (h - l) / 2;
            if (matrix[rowm][0] == target){
                return true;
            }else if(matrix[rowm][0] < target){
                l = rowm;
            }else {
                h = rowm;
            }
        }
        if(matrix[h][0] <= target){
            row = h;
        }else if(matrix[l][0] <= target){
            row = l;
        } else {
            return false;
        }
        
        l = 0;
        h = col-1;
        while(l + 1 < h){
            int colm = l + (h - l) / 2;
            if(matrix[row][colm] == target){
                return true;
            }else if(matrix[row][colm] < target){
                l = colm;
            }else {
                h = colm;
            }
        }
        if(matrix[row][l] == target){
            return true;
        }else if(matrix[row][h] == target){
            return true;
        }
        return false;
    }
}

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
