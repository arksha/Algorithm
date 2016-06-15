//80. Remove Duplicates from Sorted Array II
//two pointers , same as I
//end-1---------i
//	1,		1,	1,	2,	2,	3,	4
//      	|	 
//      	end

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<3) return nums.length;
        int end = 1;
        for(int i = 2;i<nums.length;i++){
            if(nums[i]!=nums[end-1])
                nums[++end] = nums[i];
        }
        return end +1;
    }
}