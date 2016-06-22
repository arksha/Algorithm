// 347. Top K Frequent Elements

// Given a non-empty array of integers, return the k most frequent elements.

// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

// use HashMap<int,int> as frequency map, 
// go through map and store to bucket use nest index (value in hashmap is the index in bucket)
// go through non-empty bucket from end to front get k number to res array.

// be ware of bucket size initialize to nums.length+1, if frequency is same, go into bucket and add one by one avoid duplication
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums==null||nums.length==0) return res;
        
        List<Integer>[] bucket = new List[nums.length+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num: nums){
            if(!map.containsKey(num)) map.put(num,1);
            else map.put(num,map.get(num)+1);
        }
        for(Integer key: map.keySet()){
            int frequency = map.get(key);
            if(bucket[frequency]==null)
                bucket[frequency] = new ArrayList<>();
            bucket[frequency].add(key);
        }
        for(int i = bucket.length-1; i>=0 ;i--){
            if(bucket[i]!=null)
            for(int n: bucket[i]){
                if(res.size()<k)
                    res.add(n);
            }
           
        }
        return res;
    }
}