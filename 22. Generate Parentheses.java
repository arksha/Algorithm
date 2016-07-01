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

// --------------------------------------------------------------------------------------------------------------
// count up, if l<n, means not enough parentheses, should add more left part;
// if r<l, means not match for all parentheses yet, should add more right part;
// if r==n means enough parentheses, put into List.

// can not using StringBuffer for String in this case.

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        String s = "";
        dfs(res,s,n,0,0);
        return res;
    }
    public void dfs(List<String> res,String s,int n,int l,int r ){
        if(r==n) {
            res.add(s);
        }else {
            if(l<n){
                dfs(res,s+"(",n,l+1,r);
            } 
            if(r<l){
                dfs(res,s+")",n,l,r+1);
            } 
                
        }
    }
}