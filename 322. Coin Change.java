//322. Coin Change
//dp[i]: min coins for amount i
//dp[i] = Math.min(dp[i],dp[i-coin]+1);
//see every kind of coin can form how many numbers at every amount
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
       for(int coin: coins){
           for(int i = coin;i<=amount;i++){
                if(dp[i-coin]!=Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]== Integer.MAX_VALUE? -1: dp[amount];
    }
}