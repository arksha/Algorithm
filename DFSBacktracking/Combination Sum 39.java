39. Combination Sum  
Difficulty: Medium
Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

------------------------------------------------------------------------------------------------------------
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates==null||candidates.length==0) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,res, list, 0,target);
        return res;
    }
    public void dfs(int[] candidates, List<List<Integer>> res, List<Integer> list, int index,int target){
        if(target <= 0){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = index; i<candidates.length; ++i){
            if(target < candidates[i]){
                return;
            }
            //this is to void duplicate combinataion solutions
            if(i != 0 && candidates[i] == candidates[i - 1]){
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates,res,list,i,target-candidates[i]);
            list.remove(list.size()-1);
        }
    }
}
