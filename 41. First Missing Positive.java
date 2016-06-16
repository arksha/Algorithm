41. First Missing Positive.java
//------------------------------------------------------------------------------------------------
//Given an unsorted integer array, find the first missing positive integer.

// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.

// Your algorithm should run in O(n) time and uses constant space.
// ------------------------------------------------------------------------------------------------

// Use projection, acturally is bucket sort
// index : 0,1, 2,3
// from 1: 1,2, 3,4  right position
// array : 3,4,-1,1

// change: -1,1,3,4  to get right position

//-------------------------------------------------------------------------------------------------

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0) return 1;
        int i = 0;
        while(i<nums.length){
            if(nums[i]!=i+1 && nums[i]>0&&nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }else i++;
        }
        
        for(i = 0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
}
//-------------------------------------------------------------------------------------------------
//another way to put this , same as above
// nums[i]!=nums[nums[i]-1] garantee avoid dead loop

// Why is there a while not if?
// while and for is acturally O(2n) complexity, they will reach positive number at most twice, 
// assume hase k positive number, definitely k<n, thus O(2k+ n-k) = O(k+n) = O(2n) = O(n)
//-------------------------------------------------------------------------------------------------
public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0) return 1;
        for(int i = 0;i<nums.length;i++){
            while(nums[i]!=i+1 && nums[i]>0&&nums[i]<=nums.length && nums[i]!=nums[nums[i]-1]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
}