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