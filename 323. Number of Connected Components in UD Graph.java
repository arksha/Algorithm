323. Number of Connected Components in an Undirected Graph
//dfs

//dfs
public class Solution {
    public int countComponents(int n, int[][] edges) {
        //corner case
        if(n<=0||edges==null) return 0;
        if(n==1&&edges.length==0) return 1;
        int res = 0;
        boolean[] visited = new boolean[n];
        //adjacent graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                res++;
                dfs(i,visited,adj);
            } 
        }
        return res;
    }
    public void dfs(int nodeid, boolean[] visited, List<List<Integer>> adj){
        if(visited[nodeid]) return;
        visited[nodeid] = true;
        List<Integer> neighbors = adj.get(nodeid);
        
        for(int neighbor: neighbors){
            dfs(neighbor,visited,adj);
        }
    }
}


//union find

//union find
public class Solution {
    private int[] unionfind;
    public int countComponents(int n, int[][] edges) {
        HashSet<Integer> set = new HashSet<>();
        unionfind = new int[n];
        //initial unionfind record
        for(int i = 0;i<n;i++){
            unionfind[i] = i;
        }
        for(int i = 0;i<edges.length;i++){
            union(edges[i][0],edges[i][1]);
        }
        for(int i = 0;i<n;i++){
            set.add(find(i));
        }
        return set.size();
        
    }
    public int find(int node){
        if(unionfind[node]==node) return node;
        unionfind[node] = find(unionfind[node]);
        return unionfind[node];
    }
    public void union(int a, int b){
        unionfind[find(a)] = find(b);
    }
}