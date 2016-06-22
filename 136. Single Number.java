// 136. Single Number


// Given an array of integers, every element appears twice except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// ---------------------------------------------------------------------------------------------------------------
// HashSet remove duplicate one, use iterator to get element in set.

public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums)
        {
            if(set.contains(num))
                set.remove(num);
            else 
                set.add(num);
        }
        return set.iterator().next();
    }
}

// modify: 

public class Solution {
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums)
        {
            if(!set.remove(num))
                set.add(num);
        }
        return set.iterator().next();
    }
}