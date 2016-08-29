Six degrees

Six degrees of separation is the theory that everyone and everything is six or fewer steps away, 
by way of introduction, from any other person in the world, 
so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.

Given a friendship relations, find the degrees of two people, return -1 if they can not been connected by friends of friends.

Example
Gien a graph:

1------2-----4
 \          /
  \        /
   \--3--/
{1,2,3#2,1,4#3,1,4#4,2,3} and s = 1, t = 4 return 2

Gien a graph:

1      2-----4
             /
           /
          3
{1#2,4#3,4#4,2,3} and s = 1, t = 4 return -1
-----------------------------------------------------------------------------
one bfs

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        if(s == t){
            return 0;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, Integer> map = new HashMap<>();
        queue.offer(s);
        map.put(s, 0);
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            int step = map.get(current);
            for(int i = 0; i < current.neighbors.size(); i++){
                UndirectedGraphNode neighbor = current.neighbors.get(i);
                if(map.containsKey(neighbor)){
                    continue;
                }
                map.put(neighbor, step + 1);
                queue.offer(neighbor);
                if(neighbor == t){
                    return step + 1;
                }
            }
            
        }
        return -1;
    }
    
}
