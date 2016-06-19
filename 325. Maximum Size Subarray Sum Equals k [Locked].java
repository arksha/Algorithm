// 325. Maximum Size Subarray Sum Equals k [Locked].java

// Given an array nums and a target value k, find the maximum length of a subarray that sums to k. 
// If there isn’t one, return 0 instead.

// Example 1:
// Given nums = [1, -1, 5, -2, 3], k = 3,
// return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

// Example 2:
// Given nums = [-2, -1, 2, 1], k = 1,
// return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

// Follow Up:
// Can you do it in O(n) time?
// ---------------------------------------------------------------------------------------------------------
// this qustion equals to find a sum of range and make this range maximize. 
// because requires to equals to k, this hint us to use hashMap, therefore to store the sum and index into hashmap
// key is sum before index i, value is i
// for every nums[i] check if there is sum-k in the map and maybe longer length of subarray
// sum - k is how much left for the sum, and can locate the former subarray index
Class Solution{
	public int maxSubArrayLen(int[] nums,int k){
		HashMap<Integer,Integer> map = new HashMap<>();
		map.add(0,-1);		//increase index from 1
		int sum = 0;
		int res = 0;
		for(int i = 0;i<nums.length;i++){
			sum += nums[i];
			if(map.containsKey(sum-k)) res = Math.max(res, i - map.get(sum-k));
			else
				map.put(sum,i);
		}
	}
}