// 32. Longest Valid Parentheses

// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


// ------------------------------------------------------------------------------------------------
// way1 dp;
// dp[i]: longest valid parentheses length end at i
// dp[0]

public class Solution {
    public int longestValidParentheses(String s) {
        //corner case
        if(s==null||s.length()<=1) return 0;
        int max = 0;
        //dp[i] shows max length end at i
        int[] dp = new int[s.length()];
        for(int right = 1;right<s.length();right++){
            //if(s[i] =')')
            if(s.charAt(right)==')'){
                int left = right- 1 - dp[right-1];
                if(left>=0&& s.charAt(left)=='('){
                    dp[right] = dp[right-1] + 2;
                    if(left-1>0){
                        dp[right] += dp[left-1];
                    }
                }
            }
            max = max> dp[right]? max: dp[right];
            //s[i]=')' skip 
        }
        
        return max;
    }
}

// --------------------------------------------------------------------------------------------------------------------
// way2 stack:
// close to LTE 
public class Solution {
    public int longestValidParentheses(String s) {
        if(s==null||s.length()==0) return 0;
        int max = 0;
        int left = -1;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='(') st.push(i);
            else{
                if(st.isEmpty()) left = i;
                else {
                    st.pop();
                    if(st.isEmpty()) max = Math.max(max,i-left);
                    else max = Math.max(max,i-st.peek());  
                }
            }
        }
       return max;
    }
}
