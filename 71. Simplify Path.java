// 71. Simplify Path

// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// click to show corner cases.

// Corner Cases:
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".

// ------------------------------------------------------------------------------------------------------------------------------
// split with "/",
// when encounter "" and "." pass,
// ".." is stack is not empty pop stack,
// otherwise push file name int the stack.

// pop stack and insert into string front to get right order of directory. 


public class Solution {
    public String simplifyPath(String path) {
        if(path==null||path.length()==0) return path;
        Stack<String> st = new Stack<>();
        
        for(String word: path.split("/")){
            if(word.length()==0||word.equals(".")) 
                continue;
            else if(word.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }
            else{
                st.push(word);
            } 
        }
        
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0,"/"+ st.pop());
        }
        return res.length()==0? "/":res.toString();
    }
}
