//240. Search a 2D Matrix II.java
//divide and conquer O(n^1.58)
//T(n) = 3T(n/2) + c
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowl = 0, coll = 0;
        int rowh = matrix.length-1, colh = matrix[0].length-1;
        return search(matrix, rowl, rowh, coll,colh, target);
    }
    public boolean search(int[][] matrix,int rowl, int rowh, int coll,int colh, int target){
        if(rowl>rowh||coll>colh) return false;
        int rowmid = (rowh+rowl)/2;//or rowl + (rowh-rowl)/2;
        int colmid = (colh+coll)/2;
        
        if(matrix[rowmid][colmid]==target) return true;
        else if(matrix[rowmid][colmid]<target) {
            return search(matrix, rowmid+1, rowh, colmid+1, colh, target)||
            search(matrix, rowmid+1, rowh, coll,colmid, target)||
            search(matrix, rowl, rowmid, colmid+1, colh, target);
            
        }
        else {
            return search(matrix, rowl, rowmid-1, coll,colmid-1, target)||
            search(matrix, rowmid, rowh, coll,colmid-1, target)||
            search(matrix, rowl, rowmid-1, colmid,colh, target);
            
        }
    }
}

//O(N+M), go through matrix from right up side to left bottom

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int i = 0, j = matrix[0].length-1;
        while(i<matrix.length && j>=0){
            int cur = matrix[i][j];
            if(cur==target) return true;
            else if(cur>target) j--;
            else i++;
        }
        return false;
    }
}