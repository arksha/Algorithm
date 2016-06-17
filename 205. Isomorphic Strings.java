// 205. Isomorphic Strings.java

// Given two strings s and t, determine if they are isomorphic.

// Two strings are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. 
// No two characters may map to the same character but a character may map to itself.

// For example,
// Given "egg", "add", return true.

// Given "foo", "bar", return false.

// Given "paper", "title", return true.

// Note:
// You may assume both s and t have the same length.
// ---------------------------------------------------------------------------------------------------------
// first approach, use two HashMap , to track every characters porjection , 
// but have to use two because there may be many to one porjection like egg -> ddd
// if valid in both maps, two strings are isomorphic.
// 
// but this approach is toooooooo low 

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Character> versemap = new HashMap<>();
        
        for(int i = 0;i<s.length();i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)&&(map.get(a)!=b)){
               return false;
            }
            if(versemap.containsKey(b) &&(versemap.get(b)!=a) ){
                return false;
            }
            map.put(a,b);
            versemap.put(b,a);
        }
        return true;
    }
}
// ---------------------------------------------------------------------------------------------------------
// use array instead of hashmap, and use index as key [       ][       ]
// much better but still cannot hold unicode only apply to ascll, otherwise will need more space

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] buf = new int[512];
        for(int i = 0;i<s.length();i++){
            if(buf[s.charAt(i)]!=buf[t.charAt(i)+256]) return false;
            buf[s.charAt(i)] = i+1;
            buf[t.charAt(i)+256] = i+1;
        }
        return true;
    }
}