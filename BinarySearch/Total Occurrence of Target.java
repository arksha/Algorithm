Total Occurrence of Target

Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.

Example
Given [1, 3, 3, 4, 5] and target = 3, return 2.

Given [2, 2, 3, 4, 6] and target = 4, return 1.

Given [1, 2, 3, 4, 5] and target = 6, return 0.

Challenge 
Time complexity in O(logn)


-------------------------------------------------------------------------------------
same as search range

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int low = 0;
        int high = A.length - 1;
        //left
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(A[mid] >= target){
                high = mid;
            }else{
                low = mid;
            }
        }
        if(A[low] == target){
            left = low; 
        }else if (A[high] == target) {
            left = high;
        }else {
            left = Integer.MIN_VALUE; 
            right = Integer.MAX_VALUE;
        }
        //right
        low = 0;
        high = A.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(A[mid] <= target){
                low = mid;
            }else {
                high = mid;
            }
        }
        if(A[high] == target){
            right = high;
        }else if(A[low] == target){
            right = low;
        }else{
            left = Integer.MIN_VALUE; 
            right = Integer.MAX_VALUE;
        }
        if(left == Integer.MIN_VALUE || right == Integer.MAX_VALUE){
            return 0;
        }else {
            return right - left + 1 ;
        }
    }
}