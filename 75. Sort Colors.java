75. Sort Colors
//at least four ways to solve this

//way one pass in place
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