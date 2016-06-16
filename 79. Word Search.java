//79. Word Search
//-----------------------------------------------------------------
// Given board =

// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
//-----------------------------------------------------------------

//dfs O(n^2)
//remember to mark visited place to avoid searching into a loop.

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0) return false;
        boolean res = false;
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(dfs(board,word,i,j,0))
                    res = true;
            }
        }
       return res; 
    }
    public boolean dfs(char[][] board, String word,int i,int j,int p){
        if(i<0||i>board.length-1||j<0||j>board[0].length-1) return false;
        if(word.charAt(p)==board[i][j]){
            char temp = board[i][j];
            board[i][j] = '#';
            if(p == word.length()-1) return true;
            else if( dfs(board,word,i+1,j,p+1)||
                    dfs(board,word,i,j+1,p+1)||
                    dfs(board,word,i-1,j,p+1)||
                    dfs(board,word,i,j-1,p+1)){
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}