//20. Valid Parentheses
// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

// ------------------------------------------------------------------------------------------------------------------------
// use stack to push left one and when match the right one to pop out.

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('){
                st.push(s.charAt(i));
            }else {
                if(st.isEmpty()) 
                    return false;
                char c = st.peek();
                if(s.charAt(i)=='}'&&c=='{'||s.charAt(i)==']'&&c=='['||s.charAt(i)==')'&&c=='(')
                        st.pop();
                else 
                    return false;
            }
        }
        return st.empty();
    }
}
// ------------------------------------------------------------------------------------------------------------------------
//use ascII to validate parentheses match or not
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{') st.push(c);
            else{
                if(st.isEmpty())
                    return false;
                char top = st.pop();
                if(c-top>2) return false;
            }
        }
        if(st.isEmpty()) return true;
        return false;
    }
}