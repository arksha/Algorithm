
//Can you do it in both recursively and iteratively?

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
