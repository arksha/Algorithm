22. Generate Parentheses 

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"

//dfs, count left parentheses and right parentheses, "("left more than  ")" return or used up return

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        dfs(res,"",n,n);
        return res;
    }
    public void dfs(List<String> res,String s,int l, int r){
        if(l>r||l<0||r<0) return;
        if(l==0&&r==0) res.add(s);
        dfs(res,s+"(",l-1,r);
        dfs(res,s+")",l,r-1);
       
    }
}