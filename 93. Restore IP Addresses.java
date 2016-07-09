// 93. Restore IP Addresses

// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// For example:
// Given "25525511135",

// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
// --------------------------------------------------------------------------------------------------------------
// dfs,  
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(res,"",0,s);
        return res;
    }
    public void dfs(List<String> res,String list,int p,String s){
        if(p==4){
            if(s.length()==0)
                res.add(list.substring(0,list.length()-1));
            return;
        }
        for(int i = 1;i<=3;i++){
            if(s.length()<i) continue;
            int val = Integer.parseInt(s.substring(0,i));
            if(val>255||i!=String.valueOf(val).length()) continue;
            /*in the case 010 the parseInt will return len=2 where val=10, but i=3, skip this.*/
            dfs(res,list+s.substring(0,i) + ".", p+1,s.substring(i));
        }
    }
}