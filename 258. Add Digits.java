// 258. Add Digits 

// Difficulty: Easy
// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

// For example:

// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

// Follow up:
// Could you do it without any loop/recursion in O(1) runtime?

// Hint:

// A naive implementation of the above process is trivial. Could you come up with other methods?
// What are all the possible results?
// How do they occur, periodically or randomly?
// You may find this Wikipedia article useful.

// https://en.wikipedia.org/wiki/Digital_root

// --------------------------------------------------------------------------------
// can divide one by one and add to next loop

public class Solution {
    public int addDigits(int num) {
        if(num>=0&&num<10){
            return num;
        }
        
        while(num>=10){
            int temp = num;
            int sum = 0;
            while(temp>0){
                sum += temp%10;
                temp /= 10;
            }
            num = sum;
        }
        return num;
    }
}
// --------------------------------------------------------------------------------
// all last digit equals to num%9, if there is no remain, equals to 9

public class Solution {
    public int addDigits(int num) {
        if(num>=0&&num<10){
            return num;
        }else if(num%9==0){
            return 9;
        }
        return num%9;
    }
}

