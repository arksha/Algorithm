// 186. Reverse Words in a String II [Locked]

// Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.

// The input string does not contain leading or trailing spaces and the words are always separated by a single space.

// For example,
// Given s = "the sky is blue",
// return "blue is sky the".

// Could you do it in-place without allocating extra space?
// -------------------------------------------------------------------------------------------------------------------------
// basic brute froce is to get every word to new array and read reverse of the array.

// but in - place, just reverse whole string and reverse every word is ok.
// remember to include the last word to reverse, by adding a condition of index== s.length().
// see I in 151.

// NB: In java String is immutable so the in put has to be char[]
class Solution{
	public void reverseWords(char[] s) {
		if(s.length<=1||s==null) return;
		reverse(s,0,s.length-1);
		int wordbegin = 0;
		for(int i = 0;i<=s.length;i++){
			if(s[i]==' '||i==s.length){
				reverse(s,wordbegin,i-1);
			}
			wordbegin = i+1;
		}
	}
	public void reverse(char[] s, int i,int j){
		while(i<j){
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}
}