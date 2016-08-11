Wood Cut

Given n pieces of wood with length L[i] (integer array). 
Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length.
What is the longest length you can get from the n pieces of wood? Given L & k, return the maximum length of the small pieces.

Notice
You couldn't cut wood into float length.

Example
For L=[232, 124, 456], k=7, return 114.

Challenge 
O(n log Len), where Len is the longest length of the wood.
----------------------------------------------------------------------------------------------------------------------------------
题目意思是说给出 n 段木材L[i], 将这 n 段木材切分为至少 k 段，这 k 段等长，求能从 n 段原材料中获得的最长单段木材长度。
以 k=7 为例，要将 L 中的原材料分为7段，能得到的最大单段长度为114, 232/114 = 2, 124/114 = 1, 456/114 = 4, 2 + 1 + 4 = 7.

其中 l 为单段最大长度，显然有 1≤l≤max(L[i]). 单段长度最小为1，最大不可能超过给定原材料中的最大木材长度。

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0){
            return 0;
        }
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        //low start from 1, high start from max length, can also sort ang get last one
        int low = 1;
        int high = max;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(woodnum(L,mid) >= k){
                low = mid;
            }else{
                high = mid;
            }
        }
        if(woodnum(L,high) >= k){
            return high;
        }
        if(woodnum(L,low) >= k){
            return low;
        }
        return 0;
        
    }
    private int woodnum(int[] L, int length){
        int num = 0;
        for(int wood : L){
            num += wood / length;
        }
        return num;
    }
}
