Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

    For example,
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

        [0,1,0,2,1,0,1,3,2,1,2,1]
           e p i
public class Solution{
    public int trap(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int i = 0;
        while(i < height.length && height[i] == 0){
            i++;
        }
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for(; i < height.length; i++){
            while(!stack.isEmpty() && height[i] >= height[stack.peek()]){
                int end = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                sum += (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[end]);
            }
            stack.push(i);
        }
        return sum;
    }
}