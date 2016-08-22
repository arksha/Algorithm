4. Median of Two Sorted Arrays

There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
-----------------------------------------------------------------------------------------------
O(m + n) merge

-----------------------------------------------------------------------------------------------
O(log (m + n))
A --s1---m1---s2-----
B -s3--m2--s4---
if m1 > m2, search for s4 and s1 section, for the k - k/2 th number
if m2 > m1, search for s2 and s3 section, for the k - k/2 th number

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if(length % 2 == 1){
            return (double)findk(nums1, 0, nums2, 0, length/2 + 1);
        }else{
            return (findk(nums1, 0, nums2, 0, length/2) + findk(nums1, 0, nums2, 0, length/2 + 1) ) / 2.0; 
        }
    }
    private int findk(int[] A, int startA, int[] B, int startB, int k){
        if(startA >= A.length){
            return B[startB + k - 1];
        }
        if(startB >= B.length){
            return A[startA + k - 1];
        }
        if(k == 1){
            return A[startA] > B[startB] ? B[startB]: A[startA];
        }
        int kvalA = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int kvalB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;
        if(kvalA < kvalB){
            return findk(A, startA + k / 2, B, startB, k - k / 2);
        }else{
            return findk(A, startA, B, startB + k / 2, k - k / 2);
        }
    }
}
