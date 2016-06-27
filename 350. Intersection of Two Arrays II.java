// 350. Intersection of Two Arrays II

// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

// Note:
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.

// Follow up:
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?


// ------------------------------------------------------------------------------------------------------------------------
// first similar appoach with HashMap
// Key: nums[i] value: frequency
// with 3loops , first to add nums1, second to check nums2 and modify frequency, third count and print into result.

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])) 
                map.put(nums1[i], map.get(nums1[i])+1);
            else 
                map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0){
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++){
           r[i] = result.get(i);
       }
       return r;
    }
}

// --------------------------------------------------------------------------------------------------------------------------
// two pointers
// same way as I, leave the same number condition, add duplicate in the result

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n1 = nums1.length,n2 = nums2.length;
        int p = 0, q = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(p<n1&&q<n2){
            if(nums1[p]==nums2[q]){
                arr.add(nums1[p]);
                p++;
                q++;
            }else if (nums1[p]>nums2[q]){
                q++;
            }else{
                p++;
            }
        }
        int[] res = new int[arr.size()];
        int i = 0;
        for(Integer num : arr){
            res[i++] = num;
        }
        return res;
    }
}
