// 244. Shortest Word Distance II [Locked]

// This is a follow up of Shortest Word Distance. 
// The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. 
// How would you optimize it?

// Design a class which receives a list of words in the constructor, 
// and implements a method that takes two words word1 and word2 
// and return the shortest distance between these two words in the list.

// For example,

// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

// Given word1 = "coding”, word2 = "practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

// Note
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
// --------------------------------------------------------------------------------------------------------------------------------------------

// use HashMap , cause put cost O(n) , get cost O(1). This case get operation has high frequency but put operation does not.
// the shortest function is simpley find shortest distance between two sorted list.
import java.util.*;
public class Solution{
	private HashMap<String, List<Integer>> map = new HashMap<>();
	public int WordDistance(String[] words){
		for(int i = 0;i<words.length;i++){
			if(!map.containsKey(words[i])){
				map.put(words[i],new ArrayList<Integer>(i));
			}else{
				map.get(words[i]).add(i);
			}
			
		}
	}
	public int shortest(String word1, String word2) {
		int min = Integer.MAX_VALUE;
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int i = 0, j = 0;
		while(i<list1.size() && j< list2.size()){
			int pos1 = list1.get(i);
			int pos2 = list2.get(i);
			if(pos1<pos2){
				min = Math.min(min,pos2-pos1);
				i++;
			}else{
				min = Math.min(min,pos1-pos2);
				j++;
			}
		}
		return min;
	}
}

// Your WordDistance object will be instantiated and called as such:  
// WordDistance wordDistance = new WordDistance(words);  
// wordDistance.shortest("word1", "word2");  
// wordDistance.shortest("anotherWord1", "anotherWord2");  
