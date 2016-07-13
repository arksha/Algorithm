// 72. Edit Distance 

// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// a) Insert a character
// b) Delete a character
// c) Replace a character
// --------------------------------------------------------------------------------------------------------------------------------
// O(m*n)
// dp[i][j] in position i for word1 and position j for word2 mininum change cost.

// i [0,word1 length + 1]
// j [0,word2 length + 1]

// base case: 
// dp[0][j] = j;
// dp[i][0] = i;

// equation:

// deletecost = dp[i-1][j] + 1
// addcost = dp[i][j-1] + 1
// editcost = dp[i-1][j-1] + if word1(i-1)== word2(j-1) ? 0:1
// dp[i][j] = min (  deletecost , addcost, editcost   )

// fill dp[][] , return dp[m][n] 

public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
       
        for(int i = 0;i<m+1;i++){
            for(int j = 0;j<n+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }else if (j==0){
                    dp[i][j] = i;
                }else{
                    int editcost = dp[i-1][j-1] + (word1.charAt(i-1)==word2.charAt(j-1)? 0:1);
                    int deletecost = dp[i-1][j]+1;
                    int addcost = dp[i][j-1]+1;
                    dp[i][j] = Math.min(Math.min(deletecost,addcost),editcost);
                }
            }
        }
        return dp[m][n];
    }
}