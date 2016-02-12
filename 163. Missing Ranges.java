//163. Missing Ranges.java
// Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.

// For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

//handle basic 3 cases and corner case

//cornor case: nums.length==0, return [lower,upper]
//1. first element, compare with lower
//2.last element, compare with upper
//3.else element, compare consecutive, adjecent element
public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) {
            if (lower == upper)
                res.add(lower + "");
            else
                res.add(lower + "->" + upper);
            return res;
        }
        for (int i = 0; i <= nums.length; i++) {
            if (i == 0) {
                if (nums[i] - lower == 1)
                    res.add(lower + "");
                else if (nums[i] - lower > 1)
                    res.add(lower + "->" + (nums[0] - 1));
            } else if (i == nums.length){
                if (upper - nums[i - 1] == 1)
                    res.add(upper + "");
                else if (upper - nums[i - 1] > 1)
                    res.add((nums[i - 1] + 1) + "->" + upper);
            } else {
                if (nums[i] - nums[i - 1] == 2)
                    res.add(nums[i - 1] + 1 + "");
                else if (nums[i] - nums[i - 1] > 2)
                    res.add((nums[i - 1] + 1) + "->" + (nums[i] - 1));
            }
        }
        return res;
    }
}