36. Valid Sudoku.java

// check existing number is valid
// ----------------------------------------------------------------------------------------------------------
// do not dummy go through the board by two nested loops, this will repeat.

// use HashSet to mark visit, check the block by divide into 9 cubes and line and row.
// every check is given the region to check, use only one variable to go through and cover all board.

// How to count the cube :
// 	imagine every region is at least start from 0 and at most 9, then i is [0,8],
// 	for looping the cube, just imagine the cube is a twisted array and use i/ totalNumber to get row and column.
// 	thus row number can start from i/9 to i/9+2, column number can start from i%9 to i%9+2

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        for(int i = 0;i<m;i++){
            if(!check(board,0,m-1,i,i) || 
                !check(board,i,i,0,m-1) ||
                !check(board,i/3*3,i/3*3+2,i%3*3,i%3*3+2))
            return false;
        }
        return true;
   
    }
    private boolean check(char[][] board,int is,int ie,int js,int je){
        HashSet<Character> set = new HashSet<>();
        for(int i = is;i<=ie;i++ ){
            for(int j = js;j<=je;j++){
                if(board[i][j]!='.'){
                    if(!set.contains(board[i][j]))
                        set.add(board[i][j]);
                    else 
                        return false;
                }
            }
        }
        return true;
    }
}