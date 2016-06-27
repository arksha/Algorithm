// 345. Reverse Vowels of a String

// Write a function that takes a string as input and reverse only the vowels of a string.

// Example 1:
// Given s = "hello", return "holle".

// Example 2:
// Given s = "leetcode", return "leotcede".

// --------------------------------------------------------------------------------------------------------------
// two pointers from start and end of string
// use isvowel function to check if is vowel
// swap every vowel
// dont forget to handle uppercase, use toLowerCase()
public class Solution {
    public String reverseVowels(String s) {
        int l = 0, h = s.length()-1;
        char[] array = s.toCharArray();
        while(l<h){
            if(!isvowel(array[l])) l++;
            else if(!isvowel(array[h])) h--;
            else {
                if(array[l]!=array[h]){
                    char temp = array[l];
                    array[l] = array[h];
                    array[h] = temp;
                }
                l++;
                h--;
                
            }
        }
        return String.valueOf(array);
    }
    public boolean isvowel(char ch){
        char c =  Character.toLowerCase(ch);//get a new c, cause tolowercase will return different
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
            return true;
        else
            return false;
    }
}