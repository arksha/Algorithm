Subarray Sum Closest

Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].

Challenge 
O(nlogn) time
------------------------------------------------------------------
similar with find subarray sum zero

class Pair{
    int sum;
    int index;
    public Pair(int sum, int index){
        this.sum = sum;
        this.index = index;
    }
}
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     * Description: this function is to get subarray that abs of sum is smallest.
     *              first to get prefix sum of array and record resonsive index pair
     *              then sort prefix sum, 
     *              compare every adjacent sum and if abs sum is the smallest 
     *              then return the index  
     */
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        if(nums.length == 1){
            res[0] = res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[nums.length + 1];
        sums[0] = new Pair(0,0);// index 0 sum is 0, change index range to 1, length
        int prev = 0;
        for(int i = 1; i < nums.length + 1; i++){
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        Arrays.sort(sums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });
        int minsum = Integer.MAX_VALUE;
        for(int i = 1; i < nums.length + 1; i++){
            if(minsum > sums[i].sum - sums[i - 1].sum){
                minsum = sums[i].sum - sums[i - 1].sum;
                if(sums[i].index > sums[i - 1].index){
                    res[0] = sums[i - 1].index;
                    res[1] = sums[i].index - 1;
                }else{
                    res[0] = sums[i].index;// start position is one more behind the index
                    res[1] = sums[i - 1].index - 1;
                }
            }
        }
        return res;
    }
}
