269. Alien Dictionary.java

There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

Note:
You may assume all letters are in lowercase.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

//topological sort ，order words 

public class Solution {
    public String alienOrder(String[] words) {
        if(words==null) return null;
        Map<Character, Set<Character>> graph = new HashMap<>();
        
        for(int i = 0;i<words.length;i++){
            for(int j = 0;j<words[i].length();j++){
                char c = words[i].charAt(j);
                if(!graph.containsKey(c)){
                    graph.put(c,new HashSet<Character>());
                }
            }
            if(i>0) orderwords(words[i-1],words[i],graph);
        }
        return toposort(graph);
    }
    public void orderwords(String a, String b , Map<Character, Set<Character>> graph){
        for(int i = 0;i<Math.min(a.length(),b.length());i++){
            char ca = a.charAt(i);
            char cb = b.charAt(i);
            if(ca!=cb){
                if(!graph.get(ca).contains(cb)) 
                    graph.get(ca).add(cb);
                break;//rest doesn't need to compare
            }
        }
    }
    public String toposort(Map<Character, Set<Character>> graph){
        StringBuilder sb = new StringBuilder();
        
        Map<Character,Integer> indegree = new HashMap<>();
        for(char c: graph.keySet()){
            for(char a: graph.get(c)){
                int count = indegree.containsKey(a) ? indegree.get(a) +1 :1;
                indegree.put(a,count);
            }
        }
        //find indegree==0, initialize the queue
        Queue<Character> queue = new LinkedList<>();
        for(char c: graph.keySet()){
            if(!indegree.containsKey(c)) queue.offer(c);
        }
        //topological sort
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            for(char a: graph.get(c)){
                indegree.put(a,indegree.get(a)-1);
                if(indegree.get(a)==0) queue.offer(a);
            }
        }
        for(int a: indegree.values()){//if there is non sorted, this is not a DAG, return false;
            if(a != 0) return "";
        }
        return sb.toString();
    }
}