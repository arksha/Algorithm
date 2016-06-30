38. Count and Say

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
----------better description------------------------------------------------------------------
"Count and Say problem" Write a code to do following: 
n String to print 
0 1 
1 1 1 
2 2 1 
3 1 2 1 1 
... 
Base case: n = 0 print "1" 

public class Solution {
    public String countAndSay(int n) {
        if(n<=0) return "";
        String res = "1";
        
        for(int i = 1;i<n;i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j = 1;j<res.length();j++){
                if(res.charAt(j)==res.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(res.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(res.charAt(res.length()-1));
            res = sb.toString();
        }
        return res;
    }
}