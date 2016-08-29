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

Update:

BFS : find all nodes and copy all nodes, then connect every neighbors in new nodes

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return node;
        }
        ArrayList<UndirectedGraphNode> nodes = findAllNodes(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = copyNodes(nodes);
        
        connectNeighbors(nodes, map);
        return map.get(node);
    }
    private ArrayList<UndirectedGraphNode> findAllNodes(UndirectedGraphNode node){
        //bfs
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> visitedSet = new HashSet<>();
        queue.offer(node);
        visitedSet.add(node);
        nodes.add(node);// add start node to list
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.poll();
            for(UndirectedGraphNode neighbor : current.neighbors){
                if(visitedSet.contains(neighbor)){
                    continue;
                }
                queue.offer(neighbor);
                visitedSet.add(neighbor);
                nodes.add(neighbor);
            }
        }
        return nodes;
    }
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> copyNodes(
        ArrayList<UndirectedGraphNode> nodes){
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();    
        for(UndirectedGraphNode node : nodes){
            map.put(node, new UndirectedGraphNode(node.label));
        }
        return map;
    }
    private void connectNeighbors(ArrayList<UndirectedGraphNode> nodes,
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map){
        for(UndirectedGraphNode node : nodes){
            UndirectedGraphNode newNode = map.get(node);
            ArrayList<UndirectedGraphNode> Neighbors = node.neighbors;
            for(UndirectedGraphNode neighbor : Neighbors){
                UndirectedGraphNode newNeighbor = map.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
    }
}
