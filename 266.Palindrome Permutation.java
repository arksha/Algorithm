//266.Palindrome Permutation
/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice?
Count the frequency of each character.
If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
*/
//just find duplicate and delete, then if remain single char is <2, use HashSet is simpler
class Solution{

	public boolean canPermutePalindrome (String s){
		HashSet<Character> set = new HashSet<>();
	    for(char c: s.toCharArray){
	    	if(!s.contains(c))
	            set.add(c);
	        else
	            set.remove(c);
	    }
	    return set<2;
	}
}