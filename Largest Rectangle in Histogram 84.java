84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
------------------------------------------------------------------------------------------------------------
Using a mono stack, to store only increasing number
if not, pop and calculate rectangle area and update the global area

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int res = 0;
        Stack<Integer> monoStack = new Stack<Integer>();
        for(int i = 0; i < heights.length + 1; i++){
            int cur = (i == heights.length) ? 0: heights[i]; //garentee all pop out
            while(!monoStack.isEmpty() && heights[monoStack.peek()] >= cur){
                int height = heights[monoStack.pop()];
                int width = monoStack.isEmpty() ? i: (i - monoStack.peek() - 1);
                res = Math.max(res, height * width);
            }
            monoStack.push(i);
        }
            
        return res;
    }
}

------------------------------------------------------------------------------------------------------------
update stack with two array

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }
        int res = 0;
        int[] leftSmall = new int[heights.length];//store left first index has small number than current number
        int[] rightSmall = new int[heights.length];
        //initial
        leftSmall[0] = -1;
        rightSmall[heights.length - 1] = heights.length;
        // calculate leftSmall for every index
        for(int i = 1; i < heights.length; i++){
            if(heights[i - 1] < heights[i]){
                leftSmall[i] = i - 1;
            }else{
                int j = i - 1;
                while(j >= 0 && heights[j] >= heights[i]){
                    j = leftSmall[j];// if left is bigger than current, it must be the bigger's first left small index for cur
                }
                leftSmall[i] = j;
            }
        }
        // calculate rightSmall for every index
        for(int i = heights.length - 2; i >= 0; i--){
            if(heights[i + 1] < heights[i]){
                rightSmall[i] = i + 1;
            }else{
                int j = i + 1;
                while(j < heights.length && heights[j] >= heights[i]){
                    j = rightSmall[j];
                }
                rightSmall[i] = j;
            }
        }        
        for(int i = 0; i < heights.length; i++){
            res = Math.max(res, heights[i] * (rightSmall[i] - leftSmall[i] - 1));// index has been increased by Small array
        }
        return res;
    }
}
