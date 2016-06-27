// 259. 3Sum Smaller [Locked]

// Given an array of n integers nums and a target, 
// find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the conditionnums[i] + nums[j] + nums[k] < target.

// For example, given nums = [-2, 0, 1, 3], and target = 2.
// Return 2. Because there are two triplets which sums are less than 2:
// [-2, 0, 1]
// [-2, 0, 3]

// Follow up:
// Could you solve it in O(n2) runtime?

// --------------s-------------------------------------------------------------------------------------------------------------------------
// two pointers:
// sort array, get i for iterator of all array,
// pointer l from i, pointer r from end.
// use count to record numberof index triplets, if find valid one, count += r-l, 
// because inside of [l,r] must also valid, no need to count, this is the key of O(n^2)
// move l and r to find eery triplets

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        
        for(int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                if(nums[i] + nums[l] + nums[r] < target) {
                    count += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        
        return count;
    }
}