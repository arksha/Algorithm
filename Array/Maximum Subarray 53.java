53. Maximum Subarray  

Difficulty: Medium
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
---------------------------------------------------------------------------------------------------
自己单开一个subarray最大还是和前面的搭伙sum大
注意最后返回res 和 第一个数谁大

public class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int res = nums[0];
        for(int i = 1;i<nums.length;i++){
            sum = Math.max(nums[i],nums[i]+sum);
            res = Math.max(sum,res);
        }
        return Math.max(res,nums[0]);
    }
}
--------------------------------------------------------------------------------------------------------------
DP: when sum > 0 is use to sum, else need to start from now
update max between sum and max
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum > 0 ? nums[i] + sum : nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
--------------------------------------------------------------------------------------------------
prefix sum , when find minsum before, it is time to minus and sum now is the biggest

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minsum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minsum);
            minsum = Math.min(minsum, sum);
        }
        return max;
    }
}
