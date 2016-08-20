// 349. Intersection of Two Arrays

// Given two arrays, write a function to compute their intersection.

// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

// Note:
// Each element in the result must be unique.
// The result can be in any order.

// ----------------------------------------------------------------------------------------------------------------
// first way , use  2 HashSet O(N) O(N)
// three for loops, one for add nums1 to set1, 
// one for check the second nums2 appears in nums1 and add into the second set,
// last is to count the all the numbers in the second map

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        for(int i = 0;i<nums1.length;i++){
            set.add(nums1[i]);
        }
        for(int i = 0;i<nums2.length;i++){
            if(set.contains(nums2[i]))
                inter.add(nums2[i]);
        }
        int[] res = new int[inter.size()];
        int c = 0;
        for(Integer num: inter){
            res[c++] = num;
        }
        return res;
    }
}
// -----------------------------------------------------------------------------------------------------------------
// second way, two pointers O(MlogM+NlogN) O(1)
// sort two list, if equals then go to next
// NB: use while move pointers to avoid dup num 
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n1 = nums1.length, n2 = nums2.length;
        int p = 0, q = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(p<n1&&q<n2){
            if(nums1[p]==nums2[q]){
                res.add(nums1[p]);
                p++;
                q++;
            }else if(nums1[p]>nums2[q]){
                q++;
            }else {
                p++;
            }
            while(p>0&& p<n1 && nums1[p]==nums1[p-1]) p++;
            while(q>0&& q<n2 && nums2[q]==nums2[q-1]) q++;
        }
        int[] inter = new int[res.size()];
        int i = 0;
        for(Integer num: res){
            inter[i++] = num; 
        }
        return inter;
    }
}
