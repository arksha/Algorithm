// 209. Minimum Size Subarray Sum

// Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. 
// If there isn't one, return 0 instead.

// For example, given the array [2,3,1,2,4,3] and s = 7,
// the subarray [4,3] has the minimal length under the problem constraint.

// click to show more practice.

// More practice:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).



// ------------------------------------------------------------------------------------------------------------------------
// O(n^2)
// use i and j two pointers to make a window, when the sum in window reach to sum s, update max to sum and record i-j index 
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int j = 0;
        int max = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0;i<nums.length;i++){
            while(j<nums.length&&sum<s){
                sum += nums[j];
                j++;
            }
            if(sum>=s){
               max = Math.min(max,j-i);
            }
            sum -= nums[i];
        }
        if(max == Integer.MAX_VALUE){
            max = 0;
        }
        return max;
    }
}