//11. Container With Most Water

// two pointers
//max area  =  (rightIndex -leftIndex) * higher board
// rightBoard > leftBoard  left++;
// leftBoard>   RightBoard  right--;
// leftBoard = rightBoard  left++ and right--;

public class Solution {
    public int maxArea(int[] height) {
        if(height==null||height.length==0) return 0;
        int l = 0;
        int r = height.length-1;
        int res = 0;
        while(l<r){
            int area = (r-l)*Math.min(height[l],height[r]);
            res = Math.max(res,area);
            if(height[r]>height[l]){
                l++;
            }
            else if(height[l]>height[r]){
                r--;
            }
            else{
                l++;
                r--;
            }
        }
        return res;
    }
}