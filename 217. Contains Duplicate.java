// 217. Contains Duplicate.java

// AC code ,but sometimes this is TLE for the worst case, every number is different, O(n) 
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])) 
                return true;
            else 
                set.add(nums[i]);
        }
        return false;
    }
}
// ---------------------------------------------------------------------------------------------------------
// this is a better and concise way to put it but still will TLE when the array is super long

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}