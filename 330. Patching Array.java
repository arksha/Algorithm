//330. Patching Array
//total is the largest range can be reached 
//if nums[i]<=total, range still can be expand, if i>nums.length || nums[i]>total, there should be number add to total, to cover [1,total*2]
public class Solution {
    public int minPatches(int[] nums, int n) {//greedy
        long total = 1;//total can be 2147483674 this large
        int i = 0;
        int add = 0;
        while(total<=n){
            if(i<nums.length && nums[i]<=total){
                total +=nums[i++];
                
            }else{
                total<<=1;
                add++;
            }
        }
        return add;
    }
}