// 344. Reverse String

// Write a function that takes a string as input and returns the string reversed.

// Example:
// Given s = "hello", return "olleh".

// ----------------------------------------------------------------------------------------------------------------------
// two pointers
// swap head and tail
// don't forget to move the pointers after swap

public class Solution {
    public String reverseString(String s) {
        int l = 0, h = s.length()-1;
        char[] array = s.toCharArray();
        while(l<h){
            if(array[l]!=array[h]){
                char temp = array[l];
                array[l] = array[h];
                array[h] = temp;
                
            }
            l++;
            h--;
        }
        s = String.valueOf(array);
        return s;
    }
}