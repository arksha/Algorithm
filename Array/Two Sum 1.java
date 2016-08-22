// 1. Two Sum

// --------------------------------------------------------------------------------
// HashMap key: target - numbers, value: index of array , 
// convient to return index back
// O(n) O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2]; 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(target - nums[i] , i);
            }else{
                res[0] = map.get(nums[i]);
                res[1] = i;
            }
                
        }
        return res;
    }
}
// --------------------------------------------------------------------------------
// Sorting with Two Pointers
// O(nlogn)
// copy original array and sort, use two pointers to find two numbers
// then go through original array and find the index of those two numbers,
// when two number are same like 2+2 = 4, NB to avoid dup

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null||nums.length==0){
            return res;
        }
        int[] nums2 = Arrays.copyOf(nums, nums.length);
	    Arrays.sort(nums2);
	    	int a = 0, b = 0;
	    	int start = 0, end = nums2.length-1;
	    	//find two nums
	    	while(start<end){
	    		int sum = nums2[start] + nums2[end];
	    		if(sum < target)
	    			start++;
	    		else if(sum > target)
	    			end--;
	    		else{
	    			a = nums2[start]; b = nums2[end];
	    			break;
	    		}
	    	}
	    	//find the index of two numbers
	    	for(int i = 0; i < nums.length; i++){
	    		if(nums[i] == a){
	    			res[0] = i;
	    			break;
	    		}
	    	}
	    	if(a != b){
	    		for(int i = 0; i < nums.length; i++){
		    		if(nums[i] == b){
		    			res[1] = i;
		    			break;
		    		}
		    	}
	    	} else{
	    		for(int i = 0; i < nums.length; i++){
		    		if(nums[i] == b && i != res[0]){
		    			res[1] = i;
		    			break;
		    		}
		    	}
	    	}
	    	
	    	return res;
    }
}
