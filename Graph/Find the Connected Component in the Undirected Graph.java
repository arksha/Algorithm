Find the Connected Component in the Undirected Graph

Find the number connected component in the undirected graph. 
Each node in the graph contains a label and a list of its neighbors. 
(a connected component (or just component) of an undirected graph is a subgraph in which any two vertices are connected to each other by paths, 
and which is connected to no additional vertices in the supergraph.)

Notice
Each connected component should sort by label.

Clarification
Learn more about representation of graphs

Example
Given graph:

A------B  C
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      D   E
Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}

--------------------------------------------------------------------------------------------------------
/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
           List<List<Integer>> components = new ArrayList<>();
           Queue<UndirectedGraphNode> queue = new LinkedList<>();
           HashSet<UndirectedGraphNode> visited = new HashSet<>();
           for(UndirectedGraphNode node : nodes){
               if(visited.contains(node)){
                   continue;
               }
               queue.offer(node);
               visited.add(node);
               //do bfs from node
               List<Integer> component = new ArrayList<>();
               while(!queue.isEmpty()){
                   UndirectedGraphNode current = queue.poll();
                   component.add(current.label);
                   for(UndirectedGraphNode neighbor : current.neighbors){
                       if(visited.contains(neighbor)){
                           continue;
                       }
                       queue.offer(neighbor);
                       visited.add(neighbor);
                   }
               }
               Collections.sort(component);
               components.add(component);
           }
           return components;
    }
}
