//44. Wildcard Matching
//1.use two pointers to go through strings
public class Solution {
    public boolean isMatch(String s, String p) {//double pointers
        int str = 0;
        int patt = 0;
        int pstar = -1;
        int ms = 0;
        while(str<s.length()){
            if(patt<p.length()&&(s.charAt(str)==p.charAt(patt)||p.charAt(patt)=='?') ){//
                str++;
                patt++;
            }else if(patt<p.length() && p.charAt(patt)=='*'){
                pstar = patt;
                ms = str;
                patt++;
            }else if(pstar!=-1){
                patt = pstar+1;
                ms++;
                str = ms;
            }else{
                return false;
            }
            
        }
        while(patt<p.length() && p.charAt(patt)=='*'){
            patt++;
        }
        return patt==p.length();
    }
}