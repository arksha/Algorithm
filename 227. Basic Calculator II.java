// 227. Basic Calculator II  

// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
//The integer division should truncate toward zero.

// You may assume that the given expression is always valid.

// Some examples:
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5
// Note: Do not use the eval built-in library function.
// -----------------------------------------------------------------------------------------------------------------------
// simple calcutation with +-*/, use one stack to store last number,
// use sign to record +-*/, use num to record current number.
// push when +-, peek and calculate and push when */.
// then added up all numbers in stack.

// use replace or manually handle white space. Don't use trim casue it only delete front and end white space.
// careful about the last number in string.

// time: O(n), Space:O(n)

public class Solution {
    public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        Stack<Integer> st = new Stack<>();
        s = s.replace(" ","");
        int num = 0;
        char sign = '+';
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+ c-'0';
            }
            if(!Character.isDigit(c)||i==s.length()-1){
                if(sign=='+'){
                    st.push(num);
                }
                if(sign=='-'){
                    st.push(-num);
                }
                if(sign=='*'){
                    st.push(st.pop()*num);
                }
                if(sign=='/'){
                    st.push(st.pop()/num);
                }
                sign = c;
                num=0;
            }
        }
        int res = 0;
        for(int i: st){
            res += i;
        }
        return res;
    }
}

// ------------------------------------------------------------------------------------------------------------------------
// use prev instead of stack to store previous number.

public class Solution {
    public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        s = s.trim().replaceAll(" ","");
        int res = 0;
        int prev = 0;
        char sign = '+';
        int num = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
               num = num*10 + c-'0';
            }
            if(!Character.isDigit(c)||i==s.length()-1){
                if(sign=='+'){
                    res += prev;
                    prev = num;
                }
                if(sign=='-'){
                    res +=prev;
                    prev = -num;
                }
                if(sign=='*'){
                    prev =prev * num;
                }
                if(sign=='/'){
                    prev =prev / num;
                }
                sign = c;
                num = 0;
            }
        }
        res+=prev;
        return res;
    }
}