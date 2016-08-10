47. Permutations II  QuestionEditorial Solution  My Submissions
Total Accepted: 80849
Total Submissions: 277667
Difficulty: Medium
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]


//------------------------------------------------------------------------------------------------------------------------------
template withe recursion
1. with duplicate numbers
2. use visited array to mark different numbers
3. if current is visited or non first number is same as former number and they both nonvisited before, skip and go to next loop

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Collections.sort(nums);
        int[] visited = new int[nums.size()];
        helper(res,list,nums,visited);
        return res;
    }
    private void helper(ArrayList<ArrayList<Integer>> res,
                        ArrayList<Integer> list,
                        ArrayList<Integer> nums,
                        int[] visited){
        if(list.size() == nums.size()){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0;i < nums.size();i++){
            if(visited[i] == 1 || i != 0 && nums.get(i) == nums.get(i - 1) && visited[i-1] == 0){
                continue;
            }
            visited[i] = 1;
            list.add(nums.get(i));
            helper(res, list, nums,visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}
