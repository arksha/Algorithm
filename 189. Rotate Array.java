// 189. Rotate Array

// Rotate an array of n elements to the right by k steps.

// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

// Note:
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

// [show hint]

// Hint:
// Could you do it in-place with O(1) extra space?
// Related problem: Reverse Words in a String II

// ----------------------------------------------------------------------------------------------------------------
// k = 3
// copy last part to temp
// [1,2,3,4,5,6,7]
//          k ->
// 	   i=0,1,2
// 		[5,6,7] temp
// copy front part to last part
// [      ][     ]
// [1,2,3,1,2,3,4]
// put temp into first part 
// [5,6,7,1,2,3,4]

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length<=1) return;
        int step = k%nums.length;
        int[] temp = new int[step];
        for(int i = 0; i < step; i++){
            temp[i] = nums[nums.length - step + i];
        }
        for(int i = nums.length - step - 1; i >= 0; i--){
            nums[i + step] = nums[i];
        }
        for(int i = 0; i < step; i++){
            nums[i] = temp[i];
        }

    }
}