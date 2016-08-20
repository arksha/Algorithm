Two Sum Closest

Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.

Example
Given array nums = [-1, 2, 1, -4], and target = 4.
The minimum difference is 1. (4 - (2 + 1) = 1).

Challenge 
Do it in O(nlogn) time complexity.

-----------------------------------------------------------------------------------------------
sort and two pointers
O(nlogn) + O(n) 
public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return Integer.MAX_VALUE;
        }
        int mindiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while(i < j){
            int sum = nums[j] + nums[i];
            int diff = Math.abs(target - sum);
            if(sum > target){
                mindiff = diff < mindiff ? diff : mindiff;
                j--;
            }else if(sum < target){
                mindiff = diff < mindiff ? diff : mindiff;
                i++;
            }else{
                return 0;
            }
            
        }
        return mindiff;
    }
}
