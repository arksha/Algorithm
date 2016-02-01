//1. topological sort with adjacent list to store graph O(m+n)
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {//topological
        int[] res = new int [numCourses];
        int[] indegree = new int[numCourses];//need to calculate indegree;
        if(prerequisites.length==0){
            for(int i = 0;i<numCourses;i++){
                res[i] = i;
            }
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){//initial adjacent graph
            ArrayList<Integer> l = new ArrayList<>();
            adj.add(l);
        }
        for(int [] edge: prerequisites){//calculate indegree
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<indegree.length;i++){//find entrance of indegree is 0
            if(indegree[i]==0)
                queue.offer(i);
        }
        int count = 0;//count visited notes number 
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[count++] = cur;
            for(int i: adj.get(cur)){
                if(--indegree[i]==0){
                    queue.offer(i);
                }
            }
        }
        return count==numCourses? res: new int[0];//if contains  circle, return an empty array
    }
}
//2.dfs with adjacent list
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {//dfs, adjecent list
        
        int len = prerequisites.length;
        int [] res = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>(numCourses);//use adjecent list to represent graph
        for(int i = 0;i<numCourses;i++)
        	adj.add(new ArrayList<Integer>());//add new list to adj list
        for(int [] edge : prerequisites){//fill up the adj list
        	adj.get(edge[0]).add(edge[1]);//[0,1] 1 is prerequist of 0, but in adj is 1->0 in the graph, if wanna finish 0,have to take 1 first
        }
        int [] visited = new int[numCourses];
        int index[] = new int[1];//record course index
        for(int i = 0;i<numCourses;i++){
        	if(visited[i]==0 && !dfs(res,index,visited,adj,i)){
        		return new int[0];
        	}
        }
        return res;

    }
    public boolean dfs(int[] res,int[] index,int[] visited,List<List<Integer>> adj, int p){
    	visited[p] = 1;//mark visited
    	for(Integer v: adj.get(p)){//go through adj list
    		if(visited[v]==1||(visited[v]==0 && !dfs(res,index,visited,adj,v)))
    			return false;
    	}
    	res[index[0]++] = p;
    	visited[p] = 2;//marked this node is deleted
    	return true;
    }
}