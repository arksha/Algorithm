//241. Different Ways to Add Parentheses

// Given a string of numbers and operators, 
// return all possible results from computing all the different possible ways to group numbers and operators. 
// The valid operators are +, - and *.


// Example 1
// Input: "2-1-1".

// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Output: [0, 2]


// Example 2
// Input: "2*3-4*5"

// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
// Output: [-34, -14, -10, -10, 10]


//divide and conquer , separate into left substring and right substring recursively

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        if(input==null||input.length()==0) return res;
        
        for(int i = 0;i<input.length();i++){
            if(!isoperate(input.charAt(i))) continue;
            
            List<Integer> left = diffWaysToCompute(input.substring(0,i));
            List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
            for(int a:left){
                for(int b: right){
                    res.add(calculate(a,b,input.charAt(i)));
                }
            }
        }
        if(res.isEmpty()) {//if input is only a number
            res.add(Integer.parseInt(input));
            return res;
        }
        return res;
    }
    public boolean isoperate(Character c){
        if(c=='+'||c=='-'||c=='*') return true;
        return false;
    }
    public int calculate(int a,int b,Character c){
        if(c=='+') return a+b;
        if(c=='-') return a-b;
        if(c=='*') return a*b;
        else return Integer.MAX_VALUE;
    }
}