// 249. Group Shifted Strings [Locked]

// Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". 
// We can keep "shifting" which forms the sequence:

// "abc" -> "bcd" -> ... -> "xyz"
// Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

// For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
// Return:

// [
//   ["abc","bcd","xyz"],
//   ["az","ba"],
//   ["acef"],
//   ["a","z"]
// ]
// Note: For the return value, each inner list's elements must follow the lexicographic order.
// ----------------------------------------------------------------------------------------------------------------------------------------
// way 1: O(n^2)
convert every key to the first version and add in the map
// use Collections to sort result

	public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    
    }
	}	
	
	// ------------------------------------------------------------------------------------------------------------------------------
	//way2
	// sort in put string array first to get right order
    // keyConverter to convert a key to see if it is in HashMap
	public class Solution {
        public List<List<String>> groupStrings(String[] strings) {
            List<List<String>> output = new ArrayList<List<String>>();

            if (strings == null || strings.length == 0)
                return output;

            Arrays.sort(strings);

            HashMap<List<Integer>, List<String>> map = new HashMap<>();
            List<String> list;

            for (String s : strings) {
                List<Integer> key = keyConverter(s);

                if (!map.containsKey(key)) {
                    list = new ArrayList<String>();
                    list.add(s);
                    map.put(key, list);
                    output.add(list);
                } else {
                    map.get(key).add(s);
                }
            }

            return output;
        }

        public static List<Integer> keyConverter(String s) {
            List<Integer> output = new ArrayList<>();

            char c = s.charAt(0);
            int temp = 0;

            for (int i = 0; i < s.length(); i++) {
                temp = s.charAt(i) - c;
                if (temp < 0)
                    temp += 26;
                output.add(temp);
            }

            return output;
        
        }
	}