77. Combinations  
Difficulty: Medium
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
--------------------------------------------------------------------------------------------------------------
no dup number and all combinations are different
dfs

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0 || k == 0){
            return res;
        }
        List<Integer> combination = new ArrayList<Integer>();
        dfs(res, combination, n, k, 1);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> combination, int n, int k, int index){
        if(combination.size() == k){
            res.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = index; i <= n; i++){
            combination.add(i);
            dfs(res, combination, n, k, i + 1);
            combination.remove(combination.size() - 1);
        }
    }
}
