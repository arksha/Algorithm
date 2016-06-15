//81. Search in Rotated Sorted Array II.java
//-------------------------------------------------------------------------------
//Follow up for "Search in Rotated Sorted Array":
//What if duplicates are allowed?

//Would this affect the run-time complexity? How and why?

//Write a function to determine if a given target is in the array.
//-------------------------------------------------------------------------------

//will become to O(n) if [ 2,2,2,2]
//[3,3,3,1,2,3] target = 2, this case will be mid == l== h, target could be in both direction.
//but still can get rid of [h] at this situation.
//so the code will be same as I, just add the third condition : nums[mid]==nums[h]   ->  h--;

public class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int mid = l+ (h-l)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]<nums[h]){
                if(target>nums[mid]&&target<=nums[h])
                    l = mid+1;
                else{
                    h = mid-1;
                }
            }else if(nums[mid]>nums[h]){
                if(target>=nums[l]&&target<nums[mid])
                    h = mid-1;
                else
                    l = mid+1;
            }else{
                h--;
            }
        }
        return false;
    }
}
