// 75. Sort Colors

// Given an array with n objects colored red, white or blue, 
// sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note:
// You are not suppose to use the library's sort function for this problem.

// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
// then 1's and followed by 2's.

// Could you come up with an one-pass algorithm using only constant space?


//at least four ways to solve this

//way one pass in place, with two pointers 
//use quick sort and pivot 
public class Solution {
    public void sortColors(int[] nums) {
        int r = 0;
        int b = nums.length-1;
        for(int i = 0;i<=b;i++){
            if(nums[i]==0) swap(nums,i,r++);
            else if(nums[i]==2) swap(nums,i--,b--);
        }
    }
    private void swap(int[] nums, int p, int q){
        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;
    }
}

