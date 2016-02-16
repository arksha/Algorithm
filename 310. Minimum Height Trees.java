310. Minimum Height Trees.java
//bfs with queue , find non leaves that far away from all leaves, start from leaves, vistied node minus degree of it till degree is 0

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] degree = new int[n];
        //corner case
        if(n==1){
            res.add(0);
            return res;
        }
        //initial graph and degree
        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<n;i++){
        //go through every leaf to start bfs
            if(degree[i]==0) return res;
            if(degree[i]==1) queue.offer(i);
        }
        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int temp = queue.poll();
                res.add(temp);
                degree[temp]--;//reduce degree of this node
                for(int j = 0;j<graph.get(temp).size();j++){// go all the adjacent node 
                    int next = graph.get(temp).get(j);
                    if(degree[next]==0) continue;
                    if(degree[next]==2) queue.offer(next);
                    degree[next]--;
                }
            }
        }
        return res;
    }
}