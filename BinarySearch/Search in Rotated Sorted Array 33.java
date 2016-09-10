Search in Rotated Sorted Array

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Example
For [4, 5, 1, 2, 3] and target=1, return 2.

For [4, 5, 1, 2, 3] and target=0, return -1.

Challenge 
O(logN) time
--------------------------------------------------------------------------------------------------------------
NB: compare with last one 

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int low = 0, high = A.length-1;
        while (low + 1 < high){
            int mid = low + (high - low) / 2;
                if (A[mid] == target){
                    return mid;
                }
                if(A[mid]> A[low]){
                    if(target >= A[low] && target <= A[mid]){
                        high = mid;
                    }else {
                        low = mid;
                    }
                }else {
                     if(target >= A[mid] && target <= A[high]){
                        low = mid;
                    }else {
                        high = mid;
                    }
                }
              
            
        }
        if(A[low] == target) {
            return low;
        }else if (A[high] == target) {
            return high;
        }else {
            return -1;
        }
    }
}

Updated: 09.10.2016

public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[start] < nums[mid]){// former part 
                if(nums[start] <= target && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid;// abandon former mono area
                }
            }else{
                if(nums[mid] <= target && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }
        return -1;
    }
}
