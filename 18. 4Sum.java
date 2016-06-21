// 18. 4Sum.java

// get four numbers sum equals target.
// return these numbers.

// ---------------------------------------------------------------------------------------------------------------------------------
// way 1: sort and two pointers

// add another loop on the 3sum, thus there will be 4 loop inside. O(n^(k-1)) k is k Sum
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        
        for(int i = 0;i<nums.length-3;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            for(int j = i+1;j<nums.length-2;j++){
                if(j!=i+1&& nums[j]==nums[j-1]) continue;
                int l = j+1, r = nums.length-1;
                while(l<r){
                    ArrayList<Integer> list = new ArrayList<>();
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum==target){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        while(l<r&&nums[l]==nums[l+1]) l++;
                        while(l<r&&nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(sum < target) 
                        l++;
                    else 
                        r--;
                }
            }
        }
        return res;
    }
}


// ------------------------------------------------------------------------------------------------------------------------------------
// way 2: HashMap 

// enum every pair of number and store the pair into hashmap
// then go through hashmap to merge pairs
// careful of duplicate 4 sum

