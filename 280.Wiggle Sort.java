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
		for(int i = 0;i<nums.length;i++){
			if(i%2==1&&nums[i]<nums[i-1]||i%2==0&&nums[i]>nums[i-1]){
				int temp = nums[i];
				nums[i] = nums[i-1];
				nums[i-1] = temp;	
			}
			
		}
	}
}