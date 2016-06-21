// 49. Group Anagrams

// Given an array of strings, group anagrams together.

// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:

// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]

// Note: All inputs will be in lower-case.

// ------------------------------------------------------------------------------------------------------------------------------------------
// use HashMap to store keystrings and list of same pattern strings, 
// sort CharArray and use String.valueOf() to convert every string into keystring,
// then check in the HashMap

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs==null || strs.length==0) return res;
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String keys = String.valueOf(array);
            if(!map.containsKey(keys))
                map.put(keys,new ArrayList<String>());
            map.get(keys).add(s);
        }
        for(String key: map.keySet()){
            Collections.sort(map.get(key));
        }
        res.addAll(map.values());
        return res;
    }
    
}