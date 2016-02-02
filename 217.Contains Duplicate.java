//217.Contains Duplicate 
//Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
public class Solution {//use hash set
    public boolean containsDuplicate(int[] nums) {//看清题目要求
         if(nums == null||nums.length==0) return false;
         HashSet<Integer> set = new HashSet<>();
         for(int i = 0;i<nums.length;i++){
             if(!set.contains(nums[i]))
                set.add(nums[i]);
             else
                return true;
         }
         return false;
    }
}
//219. Contains Duplicate II
//Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
//use hashmap
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null||nums.length<2) return false;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i])<=k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}
//220.Contains Duplicate III 
	//1.brute force O(n^2)
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {//naive approach TLE
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(Math.abs(nums[j]-nums[i])<=t&&j-i<=k)
                    return true;
            }
        }
        return false;
    }
}
	//2.BST  use treeset to implement BST (actually treeset is a red black tree), use floor (the biggest num below cur),use ceiling(the smallest num after i)
    // slide window to maintain conditions
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<1||t<0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0;i<nums.length;i++){
            int n = nums[i];
            if(set.ceiling(n) != null && set.ceiling(n) - n <= t ||
                set.floor(n) != null && n <= t + set.floor(n))
                    return true;
            set.add(n);
            if(i>=k)// remind add =
                set.remove(nums[i-k]);
        }
        return false;
    }
}