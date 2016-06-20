#Locked #

##1.Easy



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




	
**339. Nested List Weight Sum**
Total Accepted: 1192 Total Submissions: 2108 Difficulty: Easy
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)

