//20. Valid Parentheses
//use stack to make compare
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