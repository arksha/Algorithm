Closest Number in Sorted Array

Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.

Return -1 if there is no element in the array.

Notice

There can be duplicate elements in the array, and we can return any of the indices with same value.

Example
Given [1, 2, 3] and target = 2, return 1.

Given [1, 4, 6] and target = 3, return 1.

Given [1, 4, 6] and target = 5, return 1 or 2.

Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.

Challenge 
O(logn) time complexity.

----------------------------------------------------------------
find first index

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int index = findFirst(A, target);
        if(index == 0){
            return 0;
        }
        if(index == A.length){
            return A.length - 1;
        }
        if(target - A[index - 1] < A[index] - target){
            return index - 1;
        }
        return index;
    }
    private int findFirst(int[] A, int target){
        int low = 0;
        int high = A.length - 1;
        
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            
            if(A[mid] < target){
                low = mid;
            }else if(A[mid] > target) {
                high = mid;
            }else {
                high = mid;
            }
        }
        if(A[low] >= target){
            return low;
        } 
        if(A[high]>= target){
            return high;
        }
        return A.length;
    }
    
}

------------------------------------------------------------------------------
this does not work


public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int low = 0;
        int high = A.length - 1;
        if(target >= A[high]){
            return high;
        }
        if(target <= A[low]){
            return low;
        }
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] < target){
                low = mid;
            }else {
                high = mid;
            }
        }
        if(A[low] == target){
            return low;
        }else if(A[high] == target){
            return high;
        }else{
            return (high - target) < (target - low) ? high: low;
            
        }
    }
}