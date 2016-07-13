// 58. Length of Last Word 

// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
// return the length of last word in the string.

// If the last word does not exist, return 0.

// Note: A word is defined as a character sequence consists of non-space characters only.

// For example, 
// Given s = "Hello World",
// return 5.

// ------------------------------------------------------------------------------------------------------------
// go through from last

public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0, i = s.length()-1;
        while(i>=0&&s.charAt(i)==' ') i--;
        while(i>=0&&s.charAt(i)!=' ') {
            len++;
            i--;
        }
        return len;
    }
}

// ------------------------------------------------------------------------------------------------------------
// use split

public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if(strings.length==0) return 0;
        return strings[strings.length-1].length();
    }
}

// ------------------------------------------------------------------------------------------------------------
// use trim, a so java way.
// use lastIndexOf(),
public class Solution {
    public int lengthOfLastWord(String s) {
		return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
       
    }
}