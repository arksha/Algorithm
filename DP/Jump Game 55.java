55. Jump Game
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Determine if you are able to reach the last index.

Notice

This problem have two method which is Greedy and Dynamic Programming.
The time complexity of Greedy method is O(n).
The time complexity of Dynamic Programming method is O(n^2).
We manually set the small data set to allow you pass the test in both ways. 
This is just to let you learn how to use this problem in dynamic programming ways. 
If you finish it in dynamic programming ways, you can try greedy method to make it accept again.

-----------------------------------------------------
O(n^2) DP
public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0){
            return false;
        }
        boolean[] canjump = new boolean[A.length];
        canjump[0] = true;
        
        for(int i = 1;i< A.length;i++){
            for(int j = 0;j < i;j++){
                if(canjump[j] && j + A[j] >=i){
                    canjump[i] = true;
                    break;
                }
            }
        }
        return canjump[A.length-1];
    }
}

------------------------------------------------------------------------
O(n) greedy
public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            if(i>max) 
                return false;
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }
}
