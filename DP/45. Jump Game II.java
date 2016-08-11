//45. Jump Game II
//greedy
//1. use 2pointers to determine how far we can go
//cur is the current region we concider, furthest is the furthest we can reach in the before current region
//if pointer i larger than cur, we can trigger another jump, if i<=cur means in the region we consider, we calculate furthest we can reach and update

public class Solution {
    public int jump(int[] nums) {
        int cur = 0;
        int furthest = 0;
        int step = 0;
        for(int i = 0;i<nums.length;i++){
            if(cur<i){
                cur = furthest;
                step++;
            }
            furthest = Math.max(i+nums[i],furthest);
        }
        return step;
    }
}