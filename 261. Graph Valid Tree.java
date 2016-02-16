// 261. Graph Valid Tree.java


// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

// For example:

// Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

// Hint:

// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
// According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
// Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


//make sure two things:
//1.these edges whether can form a cycle-> if has cycle , cannot be tree
//2.these edges can connect all nodes, if has lonely nodes, cannot be tree

//dfs 
//dfs:get edges to adjecent lists, to determine whether has cycle or not O(m+n)
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // adjacent list
        List<List<Integer>> adj = new ArrayList<List<Integer>>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if(!checkhelper(n,edges,0,-1,visited,adj)) return false;
        
        for(boolean v: visited){//check lonely islands
            if(!v) return false;
        }
        return true;
    }
    public boolean checkhelper(int n, int[][] edges,int nodeid, int parentid, boolean[] visited,List<List<Integer>> adj ){
        if(visited[nodeid]) return false;
        visited[nodeid] = true;
        List<Integer> neighbors = adj.get(nodeid);
        for(Integer neighbor : neighbors){
            if(neighbor!= parentid && !checkhelper(n,edges,neighbor,nodeid,visited,adj)) return false;
        }
        return true;
    }
}

//bfs

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int nodeid = queue.poll();
            if(visited[nodeid]) return false;
            visited[nodeid] = true;
            for(int neighbor : adj.get(nodeid)){
                if(!visited[neighbor]) queue.offer(neighbor);
            }
        }
        for(boolean v: visited){
            if(!v) return false;
        }
        return true;
    }
}

//1. construct a  union find class

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i = 0;i<edges.length;i++){
            if(!uf.union(edges[i][0],edges[i][1]))//if two nodes in the same union, then new edges will generate circle
            return false;
        }
        return uf.countunion()==1;
    }
    public class UnionFind{
        int [] ids;
        int count;
        public UnionFind(int size){
            this.ids = new int[size];
            for(int i = 0;i<this.ids.length;i++){
                this.ids[i] = i;
            }
            this.count = size;
        }
        public boolean union(int a, int b){
            int src = find(a);
            int dst = find(b);
            //if not in same union , combine to one
            if(src!=dst){
                for(int i = 0;i<ids.length;i++){
                    if(ids[i]==src) ids[i] = dst;
                }
                count--;
                return true;
            }else
                return false;
        }
        public int find(int a){
            return ids[a];
        }
        public boolean isconnect(int a, int b){
            return find(a)== find(b);
        }
        public int countunion(){
            return count;
        }
    }
}

//2. a more consice way of using  Union-find

public class Solution {
    private int[] unionfind;
    public boolean validTree(int n, int[][] edges) {
        //tree should have n nodes with n-1 edges
        if(n-1!=edges.length) return false;
        unionfind = new int[n];
        for(int i = 0;i<n;i++){
            unionfind[i] = i;
        }
        for(int[] edge: edges){
            if(find(edge[0])==find(edge[1]))
                return false;
            union(edge[0],edge[1]);
        }
        return true;
    }
    public void union(int a, int b){
        unionfind[find(a)] = find(b);
    }
    public int find(int a){
        if(unionfind[a]==a) return a;
        
        unionfind[a] = find(unionfind[a]);
        return unionfind[a];
    }
}