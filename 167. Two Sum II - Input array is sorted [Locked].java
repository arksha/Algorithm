// 167. Two Sum II - Input array is sorted [Locked]

// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
// The function twoSum should return indices of the two numbers such that they add up to the target,where index1 must be less than index2. 
// Please note that your returned answers (both index1 and index2) are not zero-based.
// You may assume that each input would have exactly one solution.
// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

// two pointers 
// from start and end of array, if sum < target, move start, else move end, till get target
// O(n)

public class Solution {  
    public int[] twoSum(int[] nums, int target) { 
    	int[] res = new int[2];
   		if( nums ==null|| nums.length==0) return res;
   		int l = 0, r = nums.length-1;
   		while(l<r){
   			int sum = nums[l]+nums[r];
   			if(sum == target){
   				res[0] = l;
   				res[1] = r;
   			}else if(sum<target){
   				l++;
   			}else {
   				r--;
   			}
   		}
   		return res;
    } 
}