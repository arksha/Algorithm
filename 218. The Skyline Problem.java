218. The Skyline Problem.java

//1. use heap 
//separate left and right point , record with height, left record as negative number, right as positive number
//sort by x cord
//construct heap and sort by height from low to high, first have to add horizon line 0 to get lowest 
//use prev to record last height point
//if is left point, offer into queue, if right point find corespondent left point and poll 
//if height is not same ,add new keypoint into result list, then get this current point height record , till all height point get done

/* sudo code
for position in sorted(all start points and all end points)
       if this position is a start point
              add its height
       else if this position is a end point
              delete its height
       
       compare current max height with previous max height, 
       if different, add current position together with this new max height to our result, 
       at the same time, update previous max height to current max height;

*/

 //in the PriorityQueue, when multiple points with the same x-coord occur, 
       //1) always keep starting points in front of the ending points, 
       //2) keep the starting points in descending order of its heights (so that you won't keep updating the max height at the same point) and 
       //3) keep the ending points in ascending order of its heights 
         //(so that you won't update the max height to the next largest height after you removed the max height ending point).
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        //separate left and right points
        for(int[] b: buildings){
            //left is negative
            height.add(new int[]{b[0],-b[2]});
            //right is positive
            height.add(new int[]{b[1],b[2]});
        }
        //sort by x-axis from the same
        Collections.sort(height, new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0]){//left is not same, sort with left
                    return a[0] - b[0];
                }else{
                    return a[1] - b[1];//left 
                }
            }
        });
        //construct heap and sort by height， with max heap
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });
        pq.offer(0);//offer landline 0 in the queue
        int prev = 0;//last keypoint height
        for(int[] h :height){
            if(h[1]<0){//put left into queue 
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);//remove coresbondent left node
            }
            int cur = pq.peek();
            if(prev!=cur){//if height is not same, add a new keypoint
                res.add(new int[]{h[0],cur});
                prev = cur;
            }
        }
        return res;   
    }
}

//divide and conquer : like merge sort
//For the divide-and-conquer approach, we have to think about how to merge two lists of "key points" into a single list. 
//we compare the first unvisited key points in both lists, and visit the point with a lower x-coordinate.
// Then we update the max height at that x-coordinate based on the height of the point. 
//In order to do this, we need to keep two variables, leftMax and rightMax which stores the current max heights from 2 lists.
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        return getSkyline(buildings, 0, buildings.length-1);
    }
    
    private ArrayList<int[]> getSkyline(int[][] buildings, int lo, int hi){
        ArrayList<int[]> result=new ArrayList<>();
        if(lo>hi)   return result;
        if(lo==hi){
            result.add(new int[]{buildings[lo][0], buildings[lo][2]});
            result.add(new int[]{buildings[lo][1], 0});
            return result;
        }
        
        int mid=(lo+hi)/2;
        ArrayList<int[]> left=getSkyline(buildings, lo, mid);
        ArrayList<int[]> right=getSkyline(buildings, mid+1, hi);
        
        int leftMax=0, rightMax=0, max=0;
        for(int i=0, j=0; i<left.size()||j<right.size(); ){
            int currentMax=0;
            if(i<left.size()&&j<right.size()&&left.get(i)[0]==right.get(j)[0]){
                leftMax=left.get(i)[1];
                rightMax=right.get(j)[1];
                currentMax=Math.max(leftMax, rightMax);
                if(currentMax!=max){
                    result.add(new int[]{left.get(i)[0], currentMax});
                    max=currentMax;
                }
                i++;
                j++;
            }
            else if(j>=right.size()||i<left.size()&&j<right.size()&&left.get(i)[0]<right.get(j)[0]){
                leftMax=left.get(i)[1];
                currentMax=Math.max(leftMax, rightMax);
                if(currentMax!=max){
                    result.add(new int[]{left.get(i)[0], currentMax});
                    max=currentMax;
                }
                i++;
            }
            else if(i>=left.size()||i<left.size()&&j<right.size()&&left.get(i)[0]>right.get(j)[0]){
                rightMax=right.get(j)[1];
                currentMax=Math.max(leftMax, rightMax);
                if(currentMax!=max){
                    result.add(new int[]{right.get(j)[0], currentMax});
                    max=currentMax;
                }
                j++;
            }
        }
        return result;
    }
}
