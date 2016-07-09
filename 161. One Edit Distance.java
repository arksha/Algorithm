// 161. One Edit Distance

// Given two strings S and T, determine if they are both one edit distance apart.
// ------------------------------------------------------------------------------------------------------------------------------
// three conditions: 
// 1. abs(slength - tlength) >1, not right;
// 2. same length: check if has only different char
// 3. has one more char than other, find if only has different one 

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
    	int slen = s.length();
    	int tlen = t.length();
    	if(Math.abs(slen-tlen)>1) return false;
    	else if(slen==tlen){
    		for(int i = 0;i<s.length();i++){
    			if(s.charAt(i)!=t.charAt(i)) return false;
    		}
    		return true;
    	}else if(slen>tlen){
    		return isoneDelete(s,t);
    	}else{
    		return isoneDelete(t,s);
    	} 
    }
    public boolean isoneDelete(String s, String t){
    	for(int i = 0;i<s.length();i++){
				char c = s.charAt(i);    		
    			if(s.charAt(i)!=t.charAt(i)){
    				return s.substring(i+1).equals(s.substring(i));
    			}
    	}
    	return true;
    }
}