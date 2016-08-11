// Search insert position , return index can be duplicate

//1. iteration O(n)

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        int i;
        for(i = 0;i<nums.length;i++){
            if(nums[i]==target)
                return i;
            if(nums[i]<target){
                continue;
            }
            if(nums[i]>target){
                return i;
            }
        }
        return i++;
    }
}
////
//2.Binary search -> recursion implement
public class Solution {
    public int searchInsert(int[] nums, int target) {//binary search  O(logn)
        if(nums==null) return 0;
        return searchInsert(nums,target,0,nums.length-1);
    }
    public int searchInsert(int[] nums,int target, int l,int r){
        int mid = (l+r)/2;
        if(target==nums[mid]) return mid;
        if(target<nums[mid]){
            return l>=mid? l:searchInsert(nums,target,l,mid-1);
        }else{
            return r<=mid? r+1:searchInsert(nums,target, mid+1,r);
        }
    }
}
Binary search - > non recursion
public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        } 
            int start = 0, end = A.length - 1;
            
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (A[mid] == target) {
                    return mid;
                } else if (A[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            
            if (A[start] >= target) {
                return start;
            } else if (A[end] >= target) {
                return end;
            } else {
                return end + 1;
            }
    }
}
