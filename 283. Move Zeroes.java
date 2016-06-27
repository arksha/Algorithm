// 283. Move Zeroes

// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

// -------------------------------------------------------------------------------------------------------------------
// use just one insert pointer, move copy non-zero to the front
// record the boundery of zero, set after boundery all zero

public class Solution {
    public void moveZeroes(int[] nums) {
        int insertpos = 0;
        for(int num: nums){
            if(num!=0) nums[insertpos++] = num;
        }
        while(insertpos<nums.length){
            nums[insertpos++] = 0;
        }
    }
}

// -------------------------------------------------------------------------------------------------------------------
// two pointers 

// p is first zero
// q is first non - zero
// swap p,q
// every time move zero pointer, set non-zero pointer to the same position too

// (p ->   )
// (q ->      )
// [0,1,0,3,12]
//  p
//    q
// [1,0,0,3,12]   
//    p
//    	 q

public class Solution {
    public void moveZeroes(int[] nums) {
        
        for(int p = 0, q = 0;p<nums.length-1 && q<nums.length;){
            if(nums[p]!=0){
                p++;
                q = p;
                continue;
            }
            if(nums[q]==0){
                q++;
                continue;
            }
                int temp;
                temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
                
                p++;
                q++;
        }
    }
}