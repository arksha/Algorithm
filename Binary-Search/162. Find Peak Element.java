// Find Peak Element 162.java

// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


// Note:
// Your solution should be in logarithmic complexity.


// ------------------------------------------------------------------------------------------
// iterative binary search
// 1. four conditions when compare with mid.
// 2. increase and decrease and hill and valley, when encounter with valley, go either way is fine

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0){
            return -1;
        }
        int low = 0, high = A.length-1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(A[mid] > A[mid -1]){
                low = mid;
            }else if(A[mid] > A[mid + 1]){
                high = mid;
            }else {
                low = mid;
            }
        }
        if(A[low] > A[high]) {
            return low;
        }else {
            return high;
        }
    }
}

// ------------------------------------------------------------------------------------------
//binary search with recursion

public class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, h = nums.length-1,mid = 0;
        while(l<h){
            mid = l+(h-l)/2;
            if(nums[mid]<nums[mid+1]) l = mid+1;
            else h = mid;
        }
        return l;
    }
}

