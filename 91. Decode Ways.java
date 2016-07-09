91. Decode Ways.java

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

use dp, 
dp[] record the ways before i;
from i = 0 to i = n;
dp[0] = 0, empty string
dp[1] only one number one way to decode
if s[i] between [1,9], dp[i] + previous ways
if s[i-1,i] between[10, 26]  dp[i] + prevous two ways
 
public class Solution {
    public int numDecodings(String s) {
        if(s==null||s.length()==0) return 0;
        int n = s.length();
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0)!='0'? 1:0;
        for(int i = 2;i<n+1;i++){
            int first = Integer.parseInt(s.substring(i-1,i));
            int second = Integer.parseInt(s.substring(i-2,i));
            if(first>=1&&first<=9) dp[i] += dp[i-1];
            if(second>=10&&second<=26) dp[i] += dp[i-2];
        }
        return dp[n];
    }
}