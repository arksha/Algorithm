// 349. Intersection of Two Arrays

// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.

// ----------------------------------------------------------------------------------------------------------------
// first way , use  2 HashSet
// three for loops, one for add nums1 to set1, 
// one for check the second nums2 appears in nums1 and add into the second set,
// last is to count the all the numbers in the second map

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        for(int i = 0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i = 0;i<nums2.length;i++){
            if(set.contains(nums2[i]))
                inter.add(nums2[i]);
        }
        int[] res = new int[inter.size()];
        int c = 0;
        for(Integer num: inter){
            res[c++] = num;
        }
        return res;
    }
}