// 14. Longest Common Prefix

// Write a function to find the longest common prefix string amongst an array of strings.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null) return "";
        if(strs.length==1) return strs[0];
        int min = Integer.MAX_VALUE;
        for(String str:strs){
           min = Math.min(min,str.length());
        }
        for(int i = 0;i<min;i++){
            for(int j = 0;j<strs.length-1;j++){
                if(strs[j].charAt(i)!=strs[j+1].charAt(i))
                    return strs[j].substring(0,i);
            }
        }
        return strs[0].substring(0,min);
        
    }
}