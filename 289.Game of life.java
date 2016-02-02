//289.Game of life
public class Solution {
    public void gameOfLife(int[][] board) {
        // deadtodead = 0
        // livetolive = 1;
        // livetodead = 2;
        // deadtolive = 3;
        //Live: <2 -> d
        //live: ==2,3->l
        //live: >3 -> d
        //dead: ==3 -> l
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                
                int count = 0;//count live cells
                for(int k = Math.max(i-1,0);k<Math.min(i+2,n);k++){
                    for(int l = Math.max(j-1,0);l<Math.min(j+2,m);l++){
                       if(board[k][l]==2||board[k][l]==1) count++;//count live cells adjecent
                    }
                }
                count -= board[i][j];//minus center;
                if(board[i][j]==0&&count==3) board[i][j] = 3;//if dead prev ,and live cell is 3, next is live status
                if(board[i][j]==1&&(count<2||count>3)) board[i][j]= 2;//if prev live,and <2||>3, live to dead, is status 2
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                board[i][j] %= 2; //dead is dead ,live is live; odd is live (for 1) , even is dead(mode 2 remain 0)
            }
        }
    }
}