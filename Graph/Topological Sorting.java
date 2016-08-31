Topological Sorting

Given an directed graph, a topological order of the graph nodes is defined as follow:

For each directed edge A -> B in graph, A must before B in the order list.
The first node in the order can be any node in the graph with no nodes direct to it.
Find any topological order for the given graph.

Notice
You can assume that there is at least one topological order in the graph.
---------------------------------------------------------------------------------
find only one order will be fine
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
       ArrayList<DirectedGraphNode> sortedlist = new ArrayList<>();
       HashMap<DirectedGraphNode, Integer> inDegreeMap = new HashMap<>();
       //calculate indegree , except root node
       for(DirectedGraphNode node : graph){
           for(DirectedGraphNode neighbor : node.neighbors){
               if(inDegreeMap.containsKey(neighbor)){
                   inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) + 1);
               }else{
                   inDegreeMap.put(neighbor, 1);//indegree should be 1
               }
           }
       }
       //add node with no indegree, the root node, then start BFS
       Queue<DirectedGraphNode> queue = new LinkedList<>();
       for(DirectedGraphNode node : graph){
           if(!inDegreeMap.containsKey(node)){
               queue.offer(node);
               sortedlist.add(node);
           }
       }
       //delete edge
       while(!queue.isEmpty()){
           DirectedGraphNode current = queue.poll();
           for(DirectedGraphNode neighbor : current.neighbors){
               inDegreeMap.put(neighbor, inDegreeMap.get(neighbor) - 1);
               if(inDegreeMap.get(neighbor) == 0){
                   sortedlist.add(neighbor);
                   queue.offer(neighbor);
               }
           }
       }
       return sortedlist;
    }
}
