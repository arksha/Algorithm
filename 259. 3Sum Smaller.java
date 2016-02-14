//259. 3Sum Smaller.java

// Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

// For example, given nums = [-2, 0, 1, 3], and target = 2.

// Return 2. Because there are two triplets which sums are less than 2:

// [-2, 0, 1]
// [-2, 0, 3]
// Follow up:
// Could you solve it in O(n2) runtime?

//1.naive appproach
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {//O(n^3)
        int res = 0;
        if(nums.length==0||nums==null) return res;
        for(int i = 0;i<nums.length-2;i++){
            for(int j = i+1;j<nums.length-1;j++){
                for(int k = j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]<target){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}

//2.follow up O(n^2)
//use two pointers , first sort, use j k pointers to point rest two numbers.
//if sum < target then move left of k; if sum>target ,then add k-j, which is all the possibilites that can be sum < target

public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]>=target){
                    k--;
                }else{
                    res += k-j;
                    j++;
                }
            }
        }
        return res;
    }
} 

