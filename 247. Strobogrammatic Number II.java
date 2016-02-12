// 247. Strobogrammatic Number II.java

// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Find all strobogrammatic numbers that are of length = n.

// For example,
// Given n = 2, return ["11","69","88","96"].

//recursion 
//corner case n==0, n==1
//recursion till remain ==0 ,remain==1, remain  -= 2;
//use level to avoid 0 is in the front
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return generate(n, 0);
    }

    private List<String> generate(int remain, int level) {
        List<String> res = new ArrayList<String>();
        
        if (remain == 0) { 
            res.add("");
            return res; 
            
        }
        if (remain == 1) { 
            
            res.add("0");
            res.add("1");
            res.add("8");
            return res; 
        }
       
        List<String> prevResults = generate(remain-2, level+1);
        for (String s: prevResults) {
            if (level > 0) { res.add("0" + s + "0"); }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        return res;
    }
}