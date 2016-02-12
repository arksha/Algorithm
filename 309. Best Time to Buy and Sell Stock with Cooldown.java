//309. Best Time to Buy and Sell Stock with Cooldown

//DP
//use buy[] and sell[] to record status of holding the stock 
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0; 
        int[] buy = new int[prices.length];//day hold stock max profit
        int[] sell = new int[prices.length];//day doesn't hold stock max profit
        buy[0] = -prices[0];
        sell[0] = 0;
        for(int i = 1;i<prices.length;i++){
            sell[i] = Math.max(buy[i-1]+prices[i],sell[i-1]);//yesterday buy,today sell || yesterday no hold stock, today also no hold stock
            if(i>=2)
                buy[i] = Math.max(buy[i-1],sell[i-2]-prices[i]); //yesterday hold stock same as today || day before yesterday sell stock and cooldown for a day
            else
                buy[i] = Math.max(buy[i-1],-prices[i]);//on day i = 1, yesterday same as today || buy today, profit just negetive
        }
        return sell[prices.length-1];
    }
}