// First Bad Version

// The code base version is an integer start from 1 to n. One day, someone committed a bad version in the code case, so it caused this version and the following versions are all failed in the unit tests. Find the first bad version.

// You can call isBadVersion to help you determine which version is the first bad one. The details interface can be found in the code's annotation part.

//  Notice

// Please read the annotation in code area to get the correct way to call isBadVersion in different language. For example, Java is SVNRepo.isBadVersion(v)


// Example
// Given n = 5:

// isBadVersion(3) -> false
// isBadVersion(5) -> true
// isBadVersion(4) -> true
// Here we are 100% sure that the 4th version is the first bad version.

// Challenge 
// You should call isBadVersion as few as possible.
	
// --------------------------------------------------------------------------------------------------------------
/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int low = 0, high = n;
        
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if (!SVNRepo.isBadVersion(mid)){
                low = mid;
            }else {
                high = mid;
            }
        }
        if(SVNRepo.isBadVersion(low)){
            return low;
        }
        else{
            return high;
        }
    }
}
