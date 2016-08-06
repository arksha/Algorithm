// Find Minimum in Rotated Sorted Array 153.java

// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.

// ------------------------------------------------------------------------------------------------------------
// 1. use a target = last position in array, to compare.
// 2. choose target like this because we can make sure that if mid <= target, 
// 	the minimum number is definitely not in [mid, high], so we can search [low, mid].
// 3. Only applicable when array is non decreased sorted.
// 4. When handling last two pointers of low and high, it is the same way to compare with target.

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0){
            return -1;
        }
        int low = 0, high = num.length-1;
        int target = num[num.length-1];
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(num[mid] <= target){
                high = mid;
            }else {
                low = mid;
            }
        }
        if(num[low] <= target){
            return num[low];
        }else {
            return num[high];
        }
    }
}

// ------------------------------------------------------------------------------------------------------------
// also recursion can work

public class Solution {
    public int findMin(int[] nums) {
        return findMin(nums,0,nums.length-1);
    }
    public int findMin(int[] nums,int l, int r){
        if(l==r) return nums[l];
        if((r-l)==1) return Math.min(nums[l],nums[r]);
        
        int mid = l + (r-l)/2;
        if(nums[l]<nums[r]) return nums[l];
        else if(nums[mid]>nums[l]) return findMin(nums,mid,r);
        else return findMin(nums,l,mid);
    }
}