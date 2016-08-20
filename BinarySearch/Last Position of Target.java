Last Position of Target

Find the last position of a target number in a sorted array. Return -1 if target does not exist.

Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 2.

For target = 5, return 5.

For target = 6, return -1.

------------------------------------------------------------------------------------------
public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < target){
                low = mid;
            }else if(nums[mid] > target){
                high = mid;
            }else {
                low = mid;
            }
        }
        if(nums[high] == target){
            return high;
        }
        if(nums[low] == target){
            return low;
        }
        return -1;
    }
}