// 1. Two Sum
// HashMap key: target - numbers, value: index of array , 
// convient to return index back
// --------------------------------------------------------------------------------
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(target - nums[i] , i);
            }else{
                res[0] = map.get(nums[i]);
                res[1] = i;
            }
                
        }
        return res;
    }
}