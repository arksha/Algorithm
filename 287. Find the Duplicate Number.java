//287. Find the Duplicate Number
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
//prove that at least one duplicate number must exist. 
//Assume that there is only one duplicate number, find the duplicate one.

//Note:
//You must not modify the array (assume the array is read only).
//You must use only constant, O(1) extra space.
//Your runtime complexity should be less than O(n2).
//There is only one duplicate number in the array, but it could be repeated more than once.

//O(nlogn) 
//二分查找（Binary Search）+ 鸽笼原理（Pigeonhole Principle）
//go through array, if the less than mid number's count no more than mid, then dup number must at [mid,h]
//else dup number is in [l,mid]
//careful of 0-nums.length-1 ,cause number starts from 1 to n, thus l = 1, h = nums.length-1, and return l = mid +1
public class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int h = nums.length-1;
        while(l<h){
            int mid = l+(h-l)/2;
            int count = 0;
            for(int i = 0;i<nums.length;i++){
                if(nums[i]<=mid){
                    count++;
                }
            }
            if(count<=mid){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        return l;
    }
}

//O(n)
//two pointers
//similar as find cycle in linked list
//use value as pointer in the array, if index and value are multiple projected, it must has a circle,
//link : https://leetcode.com/discuss/61086/java-time-and-space-solution-similar-find-loop-in-linkedlist
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}