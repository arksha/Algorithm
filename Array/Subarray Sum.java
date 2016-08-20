Subarray Sum

Given an integer array, find a subarray where the sum of numbers is zero. 
Your code should return the index of the first number and the index of the last number.

Notice
There is at least one subarray that it's sum equals to zero.

Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3]
-----------------------------------------------------------------------------------------------------------
O(n) 
use hashmap store prefix sum, when find equal num in map, it is the start position
add sum 0 when index is -1 at the front(0, -1), it will easier to count sum
avoid case like [-1, 1] goes wrong 
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();//key sum ;value index
        map.put(0, -1);// index -1 sum is 0     
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(!map.containsKey(sum)){
                map.put(sum, i); 
            }else{
                res.add(map.get(sum) + 1);// index + 1 is the start postion
                res.add(i);
                return res;
            }
        }
        
        return res;
    }
   
}
