// 26. Remove Duplicates from Sorted Array.java

// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array nums = [1,1,2],

// Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
// It doesn't matter what you leave beyond the new length.

// -------------------------------------------------------------------------------------------------------------------------
//two pointers , same as II
// end is the position of last repeat, copy number of pointer i to end 
// if i == end, move i to a not equal one
// if i != end, move end and copy i to end if two pointers are not in same place
// return end + 1
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

