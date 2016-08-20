367. Valid Perfect Square  

Difficulty: Medium
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False

------------------------------------------------------------------------------------------------
binary search 
Time Complexity O(logN)
NB: use long type to avoid overflow

public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 0) {
            return true;
        }
        if(num < 0){
            return false;
        }
        long low = 1;
        long high = num / 2;
        
        while(low + 1 < high){
            long mid = low + (high - low) / 2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                low = mid;
            }else {
                high = mid;
            }
        }
        if(low * low == num || high * high == num){
            return true;
        }
        return false;
        
    }
}

