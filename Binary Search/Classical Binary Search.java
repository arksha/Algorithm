Classical Binary Search

Find any position of a target number in a sorted array. Return -1 if target does not exist.

Example
Given [1, 2, 2, 4, 5, 5].

For target = 2, return 1 or 2.

For target = 5, return 4 or 5.

For target = 6, return -1.

Challenge 
O(logn) time

------------------------------------------------------------------------------------------------------

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                high = mid;
            }else {
                low = mid;
            }
        }
        
        if(nums[low] == target){
            return low;    
        }else if (nums[high] == target){
            return high;
        }else {
            return -1;
        }
    }
}

------------------------------------------------------------------------------------------------------
recursive

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int findPosition(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        return recursion(nums, 0, nums.length - 1, target);
    }
    private int recursion(int[] nums, int low, int high, int target){
        if(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(target > nums[mid]){
                return recursion(nums, mid, high, target);
            }
            if(target < nums[mid]){
                return recursion(nums,low, mid, target);
            }
        }
        
        return -1;
    }
}