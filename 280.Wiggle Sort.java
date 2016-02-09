//280.Wiggle Sort
// Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

// For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].

//1. sort then change every odd position

Public Class Solution{
	Public void wiggleSort(int[] nums){
		Arrays.sort(nums);
		for(int i = 2;i<nums.length;i+=2){
			int temp = nums[i];
			nums[i] = nums[i-1];
			nums[i-1] = temp;
		}
	}
}
//2. just change when odd postion nums[i]<nums[i-1] or when even postion nums[i]>nums[i-1]
Public Class Solution{
	Public void wiggleSort(int[] nums){
		for(int i = 1;i<nums.length;i++){
			if(i%2==1&&nums[i]<nums[i-1]||i%2==0&&nums[i]>nums[i-1]){
				int temp = nums[i];
				nums[i] = nums[i-1];
				nums[i-1] = temp;	
			}
			
		}
	}
}

324.Wiggle Sort II

// Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

// Example:
// (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
// (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

// Note:
// You may assume all input has valid answer.

// Follow Up:
// Can you do it in O(n) time and/or in-place with O(1) extra space?

//1.separate and choose from 2 groups to form pairs
//O(nlogn) 
public class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null||nums.length<2) return;
        int mid =   (nums.length-1)/2;
        int l = mid;
        int r = nums.length-1;
        int[] temp = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0;i<nums.length;i++){
            if(i%2==0){
                temp[i] = nums[l];
                l--;
            }else{
                temp[i] = nums[r];
                r--;
            }
            
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }
}

//2. O(n) quick sort conception


