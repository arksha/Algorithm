//1.topological sort with queue
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {//bfs topo
         List<List<Integer>> adj = new ArrayList<>(numCourses);
        int [] indegree = new int[numCourses];
        //initial graph with empty
        for(int i = 0;i<numCourses;i++){
            ArrayList<Integer> l = new ArrayList<>();
            adj.add(l);
        }
        //calculate indegree
        for(int[] edge: prerequisites){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        //find entrance of graph
        Queue<Integer> queue  = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            for(int i:adj.get(cur)){
                if(--indegree[i]==0){
                    queue.offer(i);
                }
            }
        }
        return count==numCourses;
    }
}

//2.dfs and hashmap// not able to use this 
public class Solution { 
    public boolean canFinish(int numCourses, int[][] prerequisites) {//dfs
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        if(prerequisites.length==0||numCourses==0)return true;
        for(int[] edge: prerequisites){
        	if(map.containsKey(edge[1])){
        		map.get(edge[1]).add(edge[0]);
        	}else{
        	    ArrayList<Integer> list = new ArrayList<>();//cannot write in the put function should seperate
        	    list.add(edge[0]);
        		map.put(edge[1],list);
        	}
        }
        int[] visit = new int [numCourses];
        for(int i = 0;i<numCourses;i++){
        	if(!dfs(map,visit,i)) return false;
        }
        return true;
    }
 	public boolean dfs(HashMap<Integer,ArrayList<Integer>> map,int[] visit,int i){
 		if(visit[i]==2) return false;//visited
 		if(visit[i]==1) return true;//visited but not in circle
 		visit[i] = 2;
 		if(map.containsKey(i)){
 			for(int j: map.get(i)){
 				if(!dfs(map,visit,j))
 					return false;
 			}
 		}
 		visit[i] = 1;
 		return  true;

 	}
}