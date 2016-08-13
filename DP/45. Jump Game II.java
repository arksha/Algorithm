//45. Jump Game II
// find out min step to get destination

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

------------------------------------------------------------------------------------------------------------
DP

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int n = A.length; 
        //for i position the minimum step to jump here
        // j is the last place come to current place
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i = 1;i<n;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0;j < i;j++){
                if(dp[i] != Integer.MAX_VALUE && j + A[j] >= i){
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}
