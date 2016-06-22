// 356.Line Reflection [Locked]

// Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

// Example 1:
// Given points = [[1,1],[-1,1]], return true.

// Example 2:
// Given points = [[1,1],[-1,-1]], return false.

// Follow up:
// Could you do better than O(n2)?

// Hint:

// Find the smallest and largest x-value for all points.
// If there is a line then it should be at y = (minX + maxX) / 2.
// For each point, make sure that it has a reflected point in the opposite side.

// ------------------------------------------------------------------------------------------------------------------------
// follow the hint:

// need varify:

public class isReflected{
	public boolean isReflected(int[][] points) {  
		if(points==null) return true;
		HashMap<Integer, ArrayList<Integer>> map  = new HashMap<>();
		for(int i = 0;i<points.length;i++){
			int x = points[i][0];
			int y = points[i][1];
			int xmin = Math.min(xmin,x);
			int xmax = Math.max(xmax,y);
			if(!map.containsKey(points[i][0]))
				map.put(x,new ArrayList<Integer>(y));
			else 
				map.put(x,map.get(x).add(y));
		}
		yx = (xmin+xmax)/2;
		for(int i = 0;i<points.length;i++){
			int x1 = 2*y - points[i][0];
			if(map.size()==0 || map.get(points[i][0]).size()==0)
				return false;
		}
		return true;
	}
	
}

// ------------------------------------------------------------------------------------------------------------------------
// grouped by y and sort x to check if on both side

public class Solution {
    public boolean isReflected(int[][] points) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            if (!map.containsKey(point[1])) map.put(point[1], new ArrayList<>());
            map.get(point[1]).add(point[0]);
        }
        Integer pre = null;
        for (List<Integer> list : map.values()) {
            if (list.size() > 2) Collections.sort(list);
            int i = 0, j = list.size() - 1;
            while (i <= j) {
                int x = list.get(i++) + list.get(j--);
                if (pre == null) pre = x;
                else if (x != pre) return false;
            }
        }
        return true;
    }
}