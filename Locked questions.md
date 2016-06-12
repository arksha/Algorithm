#Locked #

##1.Easy

**266 Palindrome Permutation**

Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

**Hint:**

Consider the palindromes of odd vs even length. What difference do you notice?

Count the frequency of each character.

If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?

	public class Solution {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            if(!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else{
                set.remove(s.charAt(i));
            }
        }
        return set.size()<2;
    }
	}

**293 Flip Game**

You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]

If there is no valid move, return an empty list []

	public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i)=='+'&&s.charAt(i+1)=='+'){
                res.add(s.substring(0,i)+"--"+s.substring(i+2));
            }
        }
        return res;
    }
	}
	
	
**252 Meeting Rooms**

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return false.

	/*
 	* Definition for an interval.
	* public class Interval {
	*     int start;
 	*     int end;
 	*     Interval() { start = 0; end = 0; }
 	*     Interval(int s, int e) { start = s; end = e; }
 	* }
 	*/
	
	public class Solution {
	    public boolean canAttendMeetings(Interval[] intervals) {
	        if(intervals==null||intervals.length==0) return true;
	        Arrays.sort(intervals,new IntervalComparator());
        
	        Interval prev = intervals[0];
	        for(int i=1; i<intervals.length; i++) {
	            if(intervals[i].start < prev.end) return false;
    	        prev = intervals[i];
        	}
	        return true;
	    }
	}
	class IntervalComparator implements Comparator<Interval>{
	    public int compare(Interval a, Interval b){
	        if(a.start==b.start) return a.end - b.end;
	        return a.start-b.start;
    	}
	}

**246. Strobogrammatic Number**

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.

Show Company Tags
Show Tags
Show Similar Problems

	public class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder s = new StringBuilder();
        for(int i = 0;i<num.length();i++){
            char c = num.charAt(i);
            switch(c){
                case '1': c = '1'; break;
                case '6': c = '9';break;
                case '9': c = '6';break;
                case '8': c = '8';break;
                case '0': c = '0';break;
                default: return false;
            }
            s.append(c);
        }
        return s.reverse().toString().equals(num);
    }
	}
	
**270. Closest Binary Search Tree Value**

Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Show Company Tags
Show Tags
Show Similar Problems
	
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root==null) return -1;
        
        double min = Double.MAX_VALUE;
        int res = root.val;
        
        while(root!=null){
            if(Math.abs(root.val-target)<min){
                min = Math.abs(root.val-target);
                res = root.val;
            } 
            if(target>root.val) root = root.right;
            else if(target<root.val) root = root.left;
            else return root.val;
        } 
        return res;
    }
   
	}

**249. Group Shifted Strings**

Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.

	public class Solution {
    public List<List<String>> groupStrings(String[] strings) {//n^2
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    
    }
	}	
	
	
	//way2
	
	public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> output = new ArrayList<List<String>>();

        if (strings == null || strings.length == 0)
            return output;

        Arrays.sort(strings);

        HashMap<List<Integer>, List<String>> map = new HashMap<>();
        List<String> list;

        for (String s : strings) {
            List<Integer> key = keyConverter(s);

            if (!map.containsKey(key)) {
                list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
                output.add(list);
            } else {
                map.get(key).add(s);
            }
        }

        return output;
    }

    public static List<Integer> keyConverter(String s) {
        List<Integer> output = new ArrayList<>();

        char c = s.charAt(0);
        int temp = 0;

        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i) - c;
            if (temp < 0)
                temp += 26;
            output.add(temp);
        }

        return output;
    
    }
	}
**276. Paint Fence**

There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

	public class Solution {
    public int numWays(int n, int k) {
        if(n==0||k==0) return 0;
        if(n==1) return k;//corner case
        int[] diff = new int[n];
        int[] same = new int[n];
        diff[0] = k;//base case
        diff[1] = k*(k-1);
        same[0] = k;
        same[1] = k;
        for(int i = 2;i<n;i++){
            diff[i] = (k-1)*diff[i-1]+same[i-1]*(k-1);
            same[i] = diff[i-1];
        }
        return diff[n-1]+same[n-1];
    }
	}
	
**288. Unique Word Abbreviation**

An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
	
	public class ValidWordAbbr {
    HashMap<String,HashSet<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s: dictionary){
            String str = s;
            if(s.length()>2){
                str = s.charAt(0)+Integer.toString(s.length()-2)+s.charAt(s.length()-1);
            }
            if(map.containsKey(str)){
                map.get(str).add(s);
            }else{
                HashSet<String> set = new HashSet<>();
                set.add(s);
                map.put(str,set);
            }
            
        }
    }

    public boolean isUnique(String word) {
        //abbr
        String s = word;
        if(s.length()>2)
            s = word.charAt(0)+Integer.toString(word.length()-2)+word.charAt(word.length()-1);
        if(!map.containsKey(s)) return true;
        else
            return map.get(s).contains(word)&&map.get(s).size()<=1;//unique by seeing hashset size is less or equal than 1
    }
	}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");

**243. Shortest Word Distance**

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

	public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int p = -1, q = -1;
        for(int i = 0;i<words.length;i++){
            String s = words[i];
            if(s.equals(word1)) p = i;
            if(s.equals(word2)) q = i;
            if(p!=-1&&q!=-1)
            min = Math.min(min,Math.abs(p-q));
        }
        return min;
        
    }
	}

**170. Two Sum III - Data structure design**

Total Accepted: 10088 Total Submissions: 41838 Difficulty: Easy

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

	public class TwoSum {
    private List<Integer> array;
    public TwoSum(){
        this.array = new ArrayList<Integer>();
    }
    // Add the number to an internal data structure.
	public void add(int number) {
	    array.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    HashMap<Integer,Integer> map = new HashMap<>();
	    for(int i = 0;i<array.size();i++){
	        if(!map.containsKey(array.get(i)))
	            map.put(value-array.get(i),array.get(i));
	        else
	            return true;
	    }
	    return false;
	}
	}


	// Your TwoSum object will be instantiated and called as such:
	// TwoSum twoSum = new TwoSum();
	// twoSum.add(number);
	// twoSum.find(value);
	
**339. Nested List Weight Sum**
Total Accepted: 1192 Total Submissions: 2108 Difficulty: Easy
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

