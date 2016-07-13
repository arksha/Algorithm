// 43. Multiply Strings

// Given two numbers represented as strings, return multiplication of the numbers as a string.

// Note:
// The numbers can be arbitrarily large and are non-negative.
// Converting the input string to integer is NOT allowed.
// You should NOT use internal library such as BigInteger.

// -------------------------------------------------------------------------------------------------------------------------
// O(MN)
// use new array res to represent result, basic idea is to use two pointers update the number should be in res.
// Start from tail to head, and fill the res from tail too.
// multiply every digit, so use two loops for that. calulate every sum and set p1, p2.
// then go through res and append every digit to string. remember the case of zero in front of res.

public class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[m+n];
        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                int multy = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = multy+ res[p2];
                res[p1] += sum/10;
                res[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num: res){
            if(sb.length()!=0||num!=0)
                sb.append(num);
        }
        return sb.length()==0? "0":sb.toString();
    }
}