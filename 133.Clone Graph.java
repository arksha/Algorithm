//133.Clone Graph 
//1.DFS recursion

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {//use hashmap to combine old graph and clone graph
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {//dfs
        if(node == null) return null;
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        map.put(node, res);
        dfs(node,map);
        return res;
    }
    public void dfs(UndirectedGraphNode node,HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
        if(node == null) return;
        for(UndirectedGraphNode nbr: node.neighbors){
            if(!map.containsKey(nbr)){
                UndirectedGraphNode nb = new UndirectedGraphNode(nbr.label);//new node in clone graph
                map.put(nbr,nb);
                dfs(nbr,map);
            }
            map.get(node).neighbors.add(map.get(nbr));
        }
    }
}

//2.bfs with HashMap and Queue
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {//bfs
        if(node == null) return null;
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<>();
        map.put(node, res);
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode top = queue.poll();
            for(UndirectedGraphNode nbr: top.neighbors){
                if(!map.containsKey(nbr)){
                    queue.offer(nbr);
                    UndirectedGraphNode neinode = new UndirectedGraphNode(nbr.label);
                    map.put(nbr,neinode);
                }
                map.get(top).neighbors.add(map.get(nbr));
                
            }
        }
        return res;
    }
}