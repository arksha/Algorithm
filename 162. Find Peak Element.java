162. Find Peak Element.java

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

