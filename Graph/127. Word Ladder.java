127. Word Ladder  

Difficulty: Medium
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

------
leetcode 

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0){
            return 0;
        }
        if(wordList == null || wordList.size() == 0){
            return 0;
        }
        HashSet<String> visited = new HashSet<>();
        if(beginWord.equals(endWord)){
            return 1;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        visited.add(beginWord);
        
        wordList.add(beginWord);
        wordList.add(endWord);
        
        int result = 1;
        while(!queue.isEmpty()){
            result++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String node = queue.poll();
                for(String neighbor: findneighbor(node, wordList)){
                    if(visited.contains(neighbor)){
                        continue;
                    }
                    if(endWord.equals(neighbor)){
                        return result;
                    }
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return 0;
    }
    private String changeChar(String node, int index, char c){
        char[] chararr = node.toCharArray();
        chararr[index] = c;
        return new String(chararr);
    }
    private ArrayList<String> findneighbor(String node, Set<String> wordList){
        ArrayList<String> neighborlist = new ArrayList<>();
        for(int i = 0; i < node.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == node.charAt(i)){
                    continue;
                }
                String nextWord = changeChar(node, i, c);
                if(wordList.contains(nextWord)){
                    neighborlist.add(nextWord);
                }
            }
        }
        return neighborlist;
    }
    
}

------------------------------------------------------------------------------------------------
public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if(dict == null || dict.isEmpty()){
            return 0;
        }
        if(start.equals(end)){
            return 1;
        }
        dict.add(end);
        
        Queue<String> queue = new LinkedList<>();
        HashSet<String> map = new HashSet<>();
        queue.offer(start);
        map.add(start);
        
        int distance = 1;
        while(!queue.isEmpty()){
            distance++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.poll();
                for(String word : getNextWord(current, dict)){
                    if(map.contains(word)){
                        continue;
                    }
                    if(word.equals(end)){
                        return distance;
                    }
                    queue.offer(word);
                    map.add(word);
                }
            }
        }
        return distance;
    }
    private String replace(String current, int index, char c){
        char[] chars = current.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    private ArrayList<String> getNextWord(String current, Set<String> dict){
        ArrayList<String> nextWords = new ArrayList<>();
        for(int i = 0; i < current.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == current.charAt(i)){
                    continue;
                }
                String nextword = replace(current, i, c);
                if(dict.contains(nextword)){
                    nextWords.add(nextword);
                }
            }
        }
        return nextWords;
    }
}
