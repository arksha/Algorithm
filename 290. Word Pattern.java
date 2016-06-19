// 290. Word Pattern.java
//almost same as 205. Isomorphic Strings just change a data structure
//two hashmap
//remember to use split(" ") to change str into string[]

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> versemap = new HashMap();
        String[] strchar  = str.split(" ");
        if(pattern.length()!= strchar.length) return false;
        for(int i = 0;i<pattern.length();i++){
            String s = strchar[i];
            Character c = pattern.charAt(i);
            if(map.containsKey(c)&&!map.get(c).equals(s)) return false;
            if(versemap.containsKey(s)&&!versemap.get(s).equals(c)) return false;
            map.put(c,s);
            versemap.put(s,c);
        }
        return true;
    }
}