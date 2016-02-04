//286.Walls and Gates
// You are given a m x n 2D grid initialized with these three possible values.
// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647. Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
// For example, given the 2D grid:

// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF 
// After running your function, the 2D grid should be:

//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4
//use BFS
import java.util.*;

public class Solution{
	public void wallsAndGates(int[][] rooms){
		if(rooms==null||rooms.length==0) return;
		int n = rooms.length;
		int m = rooms[0].length;
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				if(rooms[i][j]==0)//if it is a door do bfs from this door
					bfs(rooms,i,j);
			}
		}
	}
	public void bfs(int[][] rooms, int i, int j){
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(i*rooms[0].length+j);
		int deep = 0;//record depth of BFS
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(i*rooms[0].length+j);
		while(!queue.isEmpty()){
			for(int k = 0;k<queue.size();k++){
				Integer cur = queue.poll();
				int row = cur/ rooms[0].length;
				int col = cur% rooms[0].length;
				rooms[row][col] = Math.min(rooms[row][col],deep);
				int up = (row-1)*rooms[0].length+col;
				int down = (row+1)*rooms[0].length+col;
				int left = row*rooms[0].length+(col-1);
				int right = row*rooms[0].length+(col+1);
				if(row>0&&rooms[row-1][col]>0&&!visited.contains(up)){
					queue.offer(up);
					visited.add(up);
				}
				if(row<rooms.length&&rooms[row+1][col]>0&&!visited.contains(down)){
					queue.offer(down);
					visited.add(down);
				}
				if(col>0&&rooms[row][col-1]>0&&!visited.contains(left)){
					queue.offer(left);
					visited.add(left);
				}
				if(col<rooms[0].length&&rooms[row][col+1]>0&&!visited.contains(right)){
					queue.offer(right);
					visited.add(right);
				}
			}
			deep++;
			

		}
	}
}