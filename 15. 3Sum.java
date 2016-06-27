// 15. 3Sum

// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]

// ------------------------------------------------------------------------------------------------------------------------------------
// two pointers, remember handle duplicate cases
// special case [0,0,0,0]

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null||nums.length<3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;//[0,0,0,0]
            int l = i+1, r = nums.length-1;
            while(l<r){
                int sum = nums[i]+ nums[l]+nums[r];
                if(sum==0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }else if(sum<0)
                    l++;
                else
                    r--;
            }
        }
        return res;
    }
}