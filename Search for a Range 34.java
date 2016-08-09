// 34. Search for a Range  

// Difficulty: Medium
// Given a sorted array of integers, find the starting and ending position of a given target value.

// Your algorithm's runtime complexity must be in the order of O(log n).

// If the target is not found in the array, return [-1, -1].

// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

// ----------------------------------------------------------------------------------------
// 1.do twice binary search
// 2. one for left boundary, one for right boundary
// 3. NB: which part to throw away
public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[2];
        if (A == null || A.length == 0){
            res[0] = res[1] = -1;
            return res;
        }
        int low = 0, high = A.length - 1;
        
        //left bound
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(A[mid] < target){
                low = mid;
            }else {
                high = mid;
            }
        }
        if(A[low] == target){
            res[0] = low;
        }else if(A[high] == target) {
            res[0] = high;
        }else {
            res[0] = res[1] = -1;
        }
        //right bound
        low = 0;
        high = A.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(A[mid] > target){
                high = mid;
            }else {
                low = mid;
            }
        }
        if(A[high] == target){
            res[1] = high;
        }else if (A[low] == target){
            res[1] = low;
        }else {
             res[0] = res[1] = -1;
        }
        return res;
    }
}
