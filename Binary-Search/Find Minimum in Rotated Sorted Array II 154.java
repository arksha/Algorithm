Find Minimum in Rotated Sorted Array II

Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.
Notice
The array may contain duplicates.

Example
Given [4,4,5,6,7,0,1,2] return 0.
----------------------------------------------------------------------------------------------------
worst will be O(n) 11111101111

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return -1;
        }
        int low = 0;
        int high = num.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            //if mid == high, means we can get rid of last equal part
            if(num[mid] == num[high]){
                high--;
            }else if(num[mid] > num[high]){
                low = mid;
            }else if(num[mid] < num[high]){
                high = mid;
            }
        }
        if(num[low] <= num[high]){
            return num[low];
        }
        return num[high];
    }
}
