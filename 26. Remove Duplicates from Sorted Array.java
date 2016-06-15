//26. Remove Duplicates from Sorted Array.java
//two pointers , same as II
//            i
//        1,  1,  2,  2,  3,  4
//        |
//        end    
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<2) return nums.length;
        int end = 0;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]!=nums[end]){
                end++;
                if(end!=i)nums[end] = nums[i];
            }
        }
        return end+1;
    }
}