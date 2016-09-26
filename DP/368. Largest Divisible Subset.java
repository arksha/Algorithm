Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

nums: [1,2,3]

Result: [1,2] (of course, [1,3] will also be ok)
Example 2:

nums: [1,2,4,8]

Result: [1,2,4,8]

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        // 3,4,8,16
        // -1, -1,1,2 parent last max index
        // 1   1 2 3  max length
        int[] parent = new int[nums.length];
        int[] maxlength = new int[nums.length];
        Arrays.fill(parent, -1);
        Arrays.fill(maxlength, 1);
            int index = 0;
            for(int i = 1; i < nums.length; i++){
                for(int j = i - 1; j >= 0; j--){
                    if(nums[i] % nums[j] == 0 && maxlength[j] + 1 > maxlength[i]){
                        parent[i] = j;
                        maxlength[i] = maxlength[j] + 1;
                    }
                }
                if(maxlength[i] > maxlength[index]){
                    index = i;
                }
            }
            while(index != -1){
                result.add(0, nums[index]);
                index = parent[index];
            }
        return result;    
    }
}
