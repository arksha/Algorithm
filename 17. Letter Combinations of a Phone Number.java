// 17. Letter Combinations of a Phone Number

// Given a digit string, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below.

// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.

// --------------------------------------------------------------------------------------------------------------
// map the keyboard first and all things left to do is just do combination for each number.
// typical dfs alg of two numbers combination.

public class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if(digits==null||digits.length()==0) return res;
        String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        dfs(digits,res,"",map,0);
        return res;
    }
    public void dfs(String digits, ArrayList<String> res,String s,String[] map,int p){
        if(p>=digits.length()){
            res.add(s);
            return;
        }
        int phoneindex = digits.charAt(p)-'0';
        for(int i = 0;i<map[phoneindex].length();i++){
            s += map[phoneindex].charAt(i);
            dfs(digits,res,s,map,p+1);
            s = s.substring(0,s.length()-1);
        }
    }
}