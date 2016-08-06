// 78. Subsets 

// Difficulty: Medium
// Given a set of distinct integers, nums, return all possible subsets.

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,3], a solution is:

// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
// ----------------------------------------------------------------------------------------------------
// 1.if need output order, sort first.
// 2.remember new arraylist when add into res, to get a copy from list
// 3.from index pos to last number

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        for(int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    } 
}

// ---------------------------------------------------------------------------------------------------
// bit manipulation
// 1. be clear of when to add number to list.
// 2. also need to sort
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int n = nums.length;
        for(int i = 0;i< (1<<n); i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0;j<nums.length;j++){
                if((i&(1 << j)) != 0){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }
}