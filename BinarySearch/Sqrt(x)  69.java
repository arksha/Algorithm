69. Sqrt(x)  
Difficulty: Medium
Implement int sqrt(int x).

Compute and return the square root of x.

------------------------------------------------------------------------------------------------------------------------------------
binary search
use long to convert

public class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        long low = 0;
        long high = x;
        while(low + 1 < high){
            long mid = low + (high - low) / 2;
            if(mid * mid <= x){
                low = mid;
            }else {
                high = mid;
            }
        }
        if (high * high <= x){
            return (int)high;
        }else {
            return (int)low;
        }
    }
}
