//16. 3Sum Closest

//similar wiht 3Sum, only add condition with closest
//initial answer as  first three number
//from 0~n-2, i~n-1 do search

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0]+ nums[1]+ nums[2];
        Arrays.sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==target) return sum;
                else if(sum>target){
                    r--;
                }else{
                    l++;
                }
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res = sum;
                }
            }
            
        }
        return res;
    }
}