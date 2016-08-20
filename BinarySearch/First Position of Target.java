// First Position of Target

// For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.

// If the target number does not exist in the array, return -1.

// ---------------------------------------------------------------------------------------------------------
// 1. O(logn) -> use binary search
// 2. 'int mid = low + (high - low) / 2;' this will lead to more left side 

// wrong answer: did not pass case : [3,4,5,8,8,8,8,10,13,14], 8
// because cannot return mid immidiately when == target.

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0, high = nums.length - 1;
        
        while(low + 1< high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){				// cannot return immdiately
                return mid;
            }else if (nums[mid] < target) {
                low = mid;
            }else {
                high = mid;
            }
        }
        if(nums[low] == target){
            return low;
        }else if(nums[high] == target){
            return high;
        }else{
            return -1;
        }
    }
}

// this is right one
class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0, high = nums.length - 1;
        
        while(low + 1< high){
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid;
            }else{
                high = mid;
            }
        }
        if(nums[low] == target){
            return low;
        }else if(nums[high] == target){
            return high;
        }else{
            return -1;
        }
    }
}