// 187. Repeated DNA Sequences.java

// Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

// Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
// Return:
// ["AAAAACCCCC", "CCCCCAAAAA"].
// ---------------------------------------------------------------------------------------------------------------------
// use two HashSet, first one is to check if substring appear more than once,second one is to get rid of duplication of output list,
// for case of ["AAAAAAAAAAA"] -> return ["AAAAAAAAAA"]

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> list=  new HashSet<>();
        for(int i = 0;i<=s.length()-10;i++){
            String sub = s.substring(i,i+10);
            if(!set.contains(sub)){
                set.add(sub);
            }else if (!list.contains(sub)){
                    list.add(sub);
            }
        }
        return new ArrayList<String>(list);
    }
}

way two : rolling hash technique  : Rabin-Karp algorithm
