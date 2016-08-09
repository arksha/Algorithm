// 90. Subsets II  

// Difficulty: Medium
// Given a collection of integers that might contain duplicates, nums, return all possible subsets.

// Note: The solution set must not contain duplicate subsets.

// For example,
// If nums = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]

// --------------------------------------------------------------------------------
// duplicate 

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null||nums.length==0) {
            return res;    
        }
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums,res,list,0);
        return res;
    }
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int p){
        res.add(new ArrayList<Integer>(list));
        for(int i = p;i<nums.length;++i){
            if(i != p && nums[i]==nums[i-1]){
                continue;    
            } 
            list.add(nums[i]);
            dfs(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}

// with different type of input:
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(S);
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res,S,list, 0);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res,
                        ArrayList<Integer> S,
                        ArrayList<Integer> list, 
                        int pos){
        res.add(new ArrayList<Integer>(list));                    
        for(int i = pos; i< S.size();i++){
           if(i != pos && S.get(i) == S.get(i-1)){
               continue;
           }
               list.add(S.get(i));
               helper(res,S,list,i+1);
               list.remove(list.size()-1);
        }
    }
}

