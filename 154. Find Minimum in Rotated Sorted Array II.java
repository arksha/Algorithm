//154. Find Minimum in Rotated Sorted Array II
//Follow up for "Find Minimum in Rotated Sorted Array":
//What if duplicates are allowed?

//Would this affect the run-time complexity? How and why?

//鸡贼题，相比I 起来考察的是分析 complexity 和最坏情况
//因为最坏情况是［1，1，1，1，1］ 这样是O(n) 的， 所以直接甩个for就好了 _(:3 <)L

public class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i = 0;i<nums.length;i++){
            if(nums[i]<min)
                min = nums[i];
        }
        return min;
    }
}

//不行就甩binary search（因为最坏情况所以可能会从 O(nlogn) 变成 O(n)）

public class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int h = nums.length-1;
        while(l+1<h){
            int mid = l + (h-l)/2;
            if(nums[mid]==nums[h]){
                h--;
            }else if(nums[mid]<nums[h]){
                h = mid;
            }else{
                l = mid;
            }
        }
        if(nums[l]<=nums[h]) return nums[l];
        return nums[h];
    }
}