// 288. Unique Word Abbreviation [Locked].java

// An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

// a) it                      --> it    (no abbreviation)

//      1
// b) d|o|g                   --> d1g

//               1    1  1
//      1---5----0----5--8
// c) i|nternationalizatio|n  --> i18n

//               1
//      1---5----0
// d) l|ocalizatio|n          --> l10n
// Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. 
// A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
// Example: 
// Given dictionary = [ "deer", "door", "cake", "card" ]

// isUnique("dear") -> false
// isUnique("cart") -> true
// isUnique("cane") -> false
// isUnique("make") -> true
// ----------------------------------------------------------------------------------------------------------------------------------------
	
	public class ValidWordAbbr {
    HashMap<String,HashSet<String>> map = new HashMap<>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s: dictionary){
            String str = s;
            if(s.length()>2){
                str = s.charAt(0)+Integer.toString(s.length()-2)+s.charAt(s.length()-1);
            }
            if(map.containsKey(str)){
                map.get(str).add(s);
            }else{
                HashSet<String> set = new HashSet<>();
                set.add(s);
                map.put(str,set);
            }
            
        }
    }

    public boolean isUnique(String word) {
        //abbr
        String s = word;
        if(s.length()>2)
            s = word.charAt(0)+Integer.toString(word.length()-2)+word.charAt(word.length()-1);
        if(!map.containsKey(s)) return true;
        else
            return map.get(s).contains(word)&&map.get(s).size()<=1;//unique by seeing hashset size is less or equal than 1
    }
	}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
