81. Search in Rotated Sorted Array II 
Difficulty: Medium

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length-1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid]==target){
                return true;
            }
            if(nums[start] < nums[mid] || nums[mid] > nums[end]){// left is sorted
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid; 
                }
            }else if(nums[mid] < nums[end] || nums[mid] < nums[end]) {//right is sorted
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }else{// dont know wherere to go
                end--;
            }
        }
        if(nums[start] == target || nums[end] == target){
            return true;
        }
        return false;
    }
}
