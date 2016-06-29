// 67. Add Binary

// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100".

// use StringBuilder to reduce the string operation cost,
// if add to hex string, just change 2 to 16

public class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1, j = b.length()-1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i>=0||j>=0){
            int m = i>=0? a.charAt(i)-'0':0;
            int n = j>=0? b.charAt(j)-'0':0;
            int sum = m+n+carry;
            carry = sum/2;
            res.insert(0,String.valueOf(sum%2));
            i--;
            j--;
        }
        if(carry!=0) res.insert(0,1);
        return res.toString();
    }
}