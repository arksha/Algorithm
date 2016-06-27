//80. Remove Duplicates from Sorted Array II

// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
// It doesn't matter what you leave beyond the new length.

------------------------------------------------------------------------------------------------------------------------
// two pointers , same as I
// only thing is to add check of same number, so start from the second element 
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