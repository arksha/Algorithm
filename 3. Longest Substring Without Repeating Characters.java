// 3. Longest Substring Without Repeating Characters

// Given a string, find the length of the longest substring without repeating characters.

// Examples:

// Given "abcabcbb", the answer is "abc", which the length is 3.

// Given "bbbbb", the answer is "b", with the length of 1.

// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

// ---------------------------------------------------------------------------------------------------------------------------------------
// HashSet and two pointers
// use i as fast pointer to detect duplicate character 
// and use j to record the duplicate in the map and delete this dup character and move j forward.
// then the size of hashset is now unique length
// update max length every time add new character.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0,j = 0;
        HashSet<Character> set = new HashSet<>();
        while(i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                max = Math.max(max,set.size());
            }else{
                set.remove(s.charAt(j++));
            }
        }
        return max;
    }
}
//prefer way 
//time O(n) , space O(min(s.length, alphabet set))
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();//store dup start index
        for(int start = 0, end = 0; end < s.length(); end++){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(start, map.get(s.charAt(end)) + 1);// start from current, 
            }
            max = Math.max(max, end - start + 1);
            map.put(s.charAt(end), end);//(each char, char's index)
            
        
        }
        return max; 
    }
}
// use int[] to implement hashtable
// in array store position of character, use array index for each ascii character
// if has duplicate, update j and the postion in map
    
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] map = new int[256];
        for(int i = 0, j = 0;i<s.length();i++){
            j = (map[s.charAt(i)]>0 )? Math.max(j, map[s.charAt(i)]) :j;
            map[s.charAt(i)] = i+1;
            res = Math.max(res,i-j+1);
        }
        return res;
    }
}

// ---------------------------------------------------------------------------------------------------------------------------------------
// way two: two pointers

