// 125. Valid Palindrome

// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.
// --------------------------------------------------------------------------------------------------------------------
// two pointers
// from start and end of string,
// only compare char when is letter and digital number, use Character.isLetterOrDigit()
// move pointers to when is not letter or digit to get valid char
// use Character.toLowerCase() handle uppercase

public class Solution {
    public boolean isPalindrome(String s) {
        int  l = 0,h = s.length()-1;
        while(l<h){
            char charl = s.charAt(l), charh = s.charAt(h);
            if(!Character.isLetterOrDigit(charl))
                l++;
            else if(!Character.isLetterOrDigit(charh))
                h--;
            else {
                if(Character.toLowerCase(charl)!=Character.toLowerCase(charh)) 
                    return false; 
                l++;
                h--;
            }
        }
        return true;
    }
}