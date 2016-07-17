// 97. Interleaving String

// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.

// --------------------------------------------------------------------------------------------------------------
// approach 1: LTE
// recursive
// choose char in s1 or char in s2 to put into s3, compare each time. if only s1==s3 choose s1 and move pointers to next position,
// if only s2== s3 move choose s2 and move, 
// if both s1 and s2 can choose, return combine with || and return.

// when reach to s1 end, check if after s2 and s3 is equal, likewise, when s2 reach to end, check after s1 and s3 is equal.

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        return helper(s1,0,s2,0,s3,0);
    }
    private boolean helper(String s1,int i, String s2,int j, String s3,int k){
        if(k == s3.length()) return true;
        if(i == s1.length()) return s2.substring(j).equals(s3.substring(k));
        if(j == s2.length()) return s1.substring(i).equals(s3.substring(k));
        
        if(s1.charAt(i)==s3.charAt(k)&&s2.charAt(j)==s3.charAt(k))
            return helper(s1,i+1,s2,j,s3,k+1)||helper(s1,i,s2,j+1,s3,k+1);
        else if(s1.charAt(i)==s3.charAt(k))
            return helper(s1,i+1,s2,j,s3,k+1);
        else if(s2.charAt(j)==s3.charAt(k))
            return helper(s1,i,s2,j+1,s3,k+1);
        else return false;
    }
}

// --------------------------------------------------------------------------------------------------------------
// DFS solution with memorization
// add a two demension boolean visited array to represent if the status is visited, cache them for next use.
// Return valid only if either i or j match k and the remaining is also valid
// This is AC

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] visited = new boolean[s1.length()+1][s2.length()+1];
        return helper(s1,0,s2,0,s3,0, visited);
    }
    private boolean helper(String s1,int i, String s2,int j, String s3,int k,boolean[][] visited){
        if(visited[i][j]) return false;
        if(k == s3.length()) return true;
        if(i == s1.length()) return s2.substring(j).equals(s3.substring(k));
        if(j == s2.length()) return s1.substring(i).equals(s3.substring(k));
        
        if(s1.charAt(i)==s3.charAt(k)&&s2.charAt(j)==s3.charAt(k)){
            boolean valid = helper(s1,i+1,s2,j,s3,k+1,visited)||helper(s1,i,s2,j+1,s3,k+1,visited);
            if(!valid) visited[i][j] = true;
            return valid;
        }
        else if(s1.charAt(i)==s3.charAt(k)){
            visited[i][j] = true;
            return helper(s1,i+1,s2,j,s3,k+1,visited);
        }
        else if(s2.charAt(j)==s3.charAt(k)){
            visited[i][j] = true;
            return helper(s1,i,s2,j+1,s3,k+1,visited);
        }
        else return false;
    }
}
// ------------------------------------------------------------------------------------------------------------
// DP solution

// dp[i][j] stands for at position s3 i+j, s1 at i, s2 at j, if is interleaving. 0 stands for empty.
// dp[0][0] all empty, is true.
// dp[0][j] s1 is empty, check s2 == s3
// dp[i][0] s2 is empty, check s1 ==s3

// dp[i][j]  = dp[i-1][j]&&s1==s3 || dp[i][j-1]&&s2==s3

// i [0,n+1]
// j [0,m+1]

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), l = s3.length();
        boolean[][] dp = new boolean[n+1][m+1];
        if(n+m!=l) return false;
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<m+1;j++){
                if(i==0&&j==0) dp[i][j] = true;
                else if(i==0){
                    dp[i][j] = dp[i][j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1));
                }else if(j==0){
                    dp[i][j] = dp[i-1][j] && (s1.charAt(i-1)==s3.charAt(i+j-1));
                }else{
                    dp[i][j] = dp[i][j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1)) ||
                            dp[i-1][j] && (s1.charAt(i-1)==s3.charAt(i+j-1));
                }
            }
        }
        return dp[n][m];
    }
}

