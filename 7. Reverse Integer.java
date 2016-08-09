// 7. Reverse Integer  

// Difficulty: Easy
// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321


// spoilers

// Have you thought about this?
// Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

// If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

// Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

// Update (2014-11-10):
// Test cases had been added to test the overflow behavior.

// --------------------------------------------------------------------------------------------------------
// get every digit and then added as a new integer.
// NB: add tester to handle overflow problem

public class Solution {
    public int reverse(int x) {
        int flag = 1;
        if(x==0 ||x>=Integer.MAX_VALUE||x<=Integer.MIN_VALUE) return 0;
        else if(x<0){
            flag = -1;
            x = -x;
        }
        long reverseint = 0;
        while(x>0){
            reverseint = reverseint*10 + x%10;
            x /= 10;
        }
        if(reverseint>Integer.MAX_VALUE||reverseint<Integer.MIN_VALUE)
            return 0;
        reverseint *= flag;
        return (int)reverseint;
    }
}