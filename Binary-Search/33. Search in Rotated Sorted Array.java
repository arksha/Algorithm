//33. Search in Rotated Sorted Array.java

//Highly frequency!!!!!

//modify binary search, throw a part at a time.
//first to see which part is not sorted, then use target to compare the sorted boundaries.
//careful of inclusive point 
public class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(target == nums[mid]) return mid;
            if(nums[mid]<nums[h]){
                if(target>nums[mid]&&target<=nums[h])
                    l = mid+1;
                else
                    h = mid-1;
            }else {
                if(target>=nums[l]&&target<nums[mid])
                    h = mid-1;
                else
                    l = mid+1;
            }
        }
       return -1; 
    }
}

// ------------------------------------------------------------------------------------------------
// updated with a gerneral method
// 1. two conditions of mid >low or mid < low
// 2. then see target is in the monoincreased section 
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
------------------------------------------------------------------------------------------------------------
