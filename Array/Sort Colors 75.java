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
-----------
bucket sort 
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int num : nums){
            if(num == 0){
                count[0]++;
            }else if(num == 1){
                count[1]++;
            }else{
                count[2]++;
            }
        }
        int zero = count[0];
        int one = count[1];
        int two = count[2];
        int i = 0;
        while(zero != 0){
            nums[i++] = 0;
            zero --;
        }
        while(one != 0){
            nums[i++] = 1;
            one --;
        }
        while(two != 0){
            nums[i++] = 2;
            two --;
        }
    }
}
//way one pass in place, with two pointers 
//use quick sort and pivot 
// public class Solution {
//     public void sortColors(int[] nums) {
//         int r = 0;
//         int b = nums.length-1;
//         for(int i = 0;i<=b;i++){
//             if(nums[i]==0) swap(nums,i,r++);
//             else if(nums[i]==2) swap(nums,i--,b--);
//         }
//     }
//     private void swap(int[] nums, int p, int q){
//         int temp = nums[p];
//         nums[p] = nums[q];
//         nums[q] = temp;
//     }
// }

update: more readable, human friendly

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     * Describ: left is index after end of 0, right is index before start of 2
     *          if cur == 2 swap it to right, cur == 0 swap it to left,
     *          if cur == 1, just move cur 
     * Notice : cur can meet right pointer
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int cur = 0;
        while(cur <= right){
            if(nums[cur] == 0 && cur != left){
                swap(nums, cur, left++);
            }else if(nums[cur] == 2 && cur != right){
                swap(nums, cur, right--);
            }else{
                cur++;
            }
        }
    }
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
