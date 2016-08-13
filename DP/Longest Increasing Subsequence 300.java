//300.Longest Increasing Subsequence
//DP O(n^2)

public class Solution {
    public int lengthOfLIS(int[] nums) {//dp
        //recurence formula:
        int dp[] = new int [nums.length];
        if(nums.length==0||nums==null) return 0;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = dp[j]+1 < dp[i]? dp[i] :dp[j]+1;//add length
                    
                }
            }
            max = Math.max(dp[i],max);
        }    
        return max;
    }
}

updated: 08.12.2016

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        int n = nums.length;
        int[] dp = new int[n];
        
        int longest = 0;
        for(int i = 0;i < n;i++){
            dp[i] = 1;//?
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            longest = Math.max(dp[i],longest);
        }
        return longest;   
    }
}
