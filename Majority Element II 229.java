Majority Element II 229.java

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.

Hint:
How many majority elements could it possibly have?
--------------------------------------------------------------------------------------------------
HashMap
O(n) O (n)
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<Integer>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);    
            }else{
                map.put(num, map.get(num) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > nums.length / 3){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
--------------------------------------------------------------------------------------------------------------
Moore voting Alg
O(n) O(1)

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        Integer major1 = null;//major number candidate 1
        Integer major2 = null;
        int count1 = 0;//count of major number 1
        int count2 = 0;
        
        for(int num : nums){
            if(major1 != null && num == major1.intValue()){
                count1++;
            }else if(major2 != null && num == major2.intValue()){
                count2++;
            }else if(count1 == 0){
                count1 = 1;
                major1 = num;
            }else if(count2 == 0){
                count2 = 1;
                major2 = num;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == major1.intValue()){
                count1++;
            }
            else if(num == major2.intValue()){// NB: add else, for case[1,1], this will cause runtime error 
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            result.add(major1);
        }
        if(count2 > nums.length / 3){
            result.add(major2);
        }
        return result;
    }
}
