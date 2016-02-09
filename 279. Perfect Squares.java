//279. Perfect Squares 
//dp[i]:min amount of number can form i
//dp[i+j*j]  i+j*j every i plus j*j(a square number), 
//the least number which sum is i+j*j, is the least number that can form a +1
//same as coin change 
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 0;i*i<=n;i++){
            dp[i*i] = 1;
        }
        for(int i = 0;i<=n;i++){
            for(int j = 0;i+j*j<=n;j++){//最远能到哪里上限就在哪里 i+j＊j
                dp[i+j*j] = Math.min(dp[i]+1,dp[i+j*j]); 
            }
        }
        return dp[n];
    }
}
//can also use number theory (lagrange's four square theorem)
//all N can be represented by at most 4 square number
