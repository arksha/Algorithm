<<<<<<< HEAD
// 46. Permutations  

// Difficulty: Medium
// Given a collection of distinct numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
// ------------------------------------------------------------------------------------------------
// recursion with typical model

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        helper(res, list, nums);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res,
                ArrayList<Integer> list,
                ArrayList<Integer> nums){
                if(list.size() == nums.size()){
                    res.add(new ArrayList<Integer>(list));
                    return;
                }
                for(int i = 0; i< nums.size();i++){
                    if(list.contains(nums.get(i))){
                        continue;
                    }    
                    list.add(nums.get(i));
                    helper(res,list,nums);
                    list.remove(list.size()-1);
                }
                    
=======
46. Permutations 

Difficulty: Medium
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

--------------------------------------------------------------------------------------------------------------
template with permutation
1. NB: sort first
2. check for each number can only be used once, by checking if current number is in the list

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }    
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();  
        helper(res, list, nums);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
>>>>>>> refs/remotes/origin/master
    }
}
