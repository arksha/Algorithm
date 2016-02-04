228. Summary Ranges
// Given a sorted integer array without duplicates, return the summary of its ranges.

// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
//two pointers
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length<1||nums==null) return res;
        int s = 0;
        int e = 0;
        for(int i = 1;i<=nums.length;i++){
            if(i!=nums.length && nums[i-1]+1==nums[i] )//put i!=nums.length first!!!!!!
                e++;
            else{
                if(e!=s)
                    res.add(Integer.toString(nums[s]) + "->"+Integer.toString(nums[e]));
                else
                    res.add(Integer.toString(nums[s]));
                s = e+1;
                e = s;
            }    
        }
        return res;
    }
}