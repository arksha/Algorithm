// 151. Reverse Words in a String

// Given an input string, reverse the string word by word.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.

// Clarification:
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.

// ------------------------------------------------------------------------------------------------
// O(N), O(N)
// split with whitespace into string array,
// can use trim and split(" +") to get rid of two boundry and multiple whitespace
// read array from tail to head, form a new string and return.
// remove the last " " at last

// NB: strings in java are immutable object so in java it has to get String into char[]

public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
			return "";
		}
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].isEmpty()) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}

// ------------------------------------------------------------------------------------------------