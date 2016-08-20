K Closest Numbers In Sorted Array

Given a target number, a non-negative integer k and an integer array A sorted in ascending order, find the k closest numbers to target in A, sorted in ascending order by the difference between the number and target. Otherwise, sorted in ascending order by number if the difference is same.

Example
Given A = [1, 2, 3], target = 2 and k = 3, return [2, 1, 3].

Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].

Challenge 
O(logn + k) time complexity.

------------------------------------------------------------------------------------------
1.get first index and use two pointers to check for rest

public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int[] res = new int[k];
        if(A == null || A.length == 0 || k > A.length){
            return A;
        }
        int index = closest(A, target);
        //res[0] = A[index];
        int start = index - 1,end = index;
        for(int i = 0; i < k;i++){
            if(start < 0){
                res[i] = A[end++];
            }else if(end > A.length - 1){
                res[i] = A[start--];
            }else{
                res[i] = (target - A[start]) <= (A[end] - target) ? A[start--] : A[end++];
            }
        }
        
        return res;
    }
    private int closest(int[] A, int target){// find first one
        int low = 0;
        int high = A.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(A[mid] == target){
                high = mid;
            }else if(A[mid] > target){
                high = mid;
            }else {
                low = mid;
            }
        }
        if(A[low] >= target){
            return low;
        }else if(A[high] >= target){
            return high;
        }else{
            return A.length;
        }
    }
}