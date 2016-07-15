214. Shortest Palindrome.java

Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".

------------------------
reverse the whole string and add it front of it is a palindrome,
but for the shortest one,
if reversed string tail has couple of same character with input string, which means the same part need not to be repeat
like 'abacd', reversed 'dcaba', 'aba' is repeated, so the shorter one is 'dcabacd'.

This leads to the problem of finding prefix and suffix.
the most popular algorithm is KMP 

public class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder res = new StringBuilder(s);
        if(s==null||s.length()==0) return res.toString();
        
        String reversestring = res.reverse().toString();
        //incase reverse 'aaaa' to 'aaaaaaaa'
        String temp = s+'#'+reversestring;
        int[] next = new int[temp.length()+1];
        //calculate next table
        getnexttable(temp, next);
        
        return new StringBuilder(s.substring(next[next.length-1])).reverse().toString()+s;
        
    }
    private void getnexttable(String s, int[] next){
        int k = -1;// prefix
        int j = 0; //suffix
        next[0] = -1;
        while(j<s.length()){
            if(k==-1||s.charAt(k)==s.charAt(j)){
                k++;
                j++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        
    }
}
