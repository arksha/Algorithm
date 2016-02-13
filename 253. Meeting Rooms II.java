253. Meeting Rooms II.java

//1.greedy
//with sort intervals by start time first and then by end time
//if overlap, then add a room, go through every pair of intervals O(n^2) time and O(n) space

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                if(a.start==b.start) return a.end-b.end;
                return a.start-b.start;
            }
        });
        return helper(new ArrayList(Arrays.asList(intervals)));
    }
    public int helper(List<Interval> list){
        if(list.size()==0) return 0;
        Interval pre = list.get(0);
        List<Interval> nextlist = new ArrayList<>();
        for(int i = 1;i<list.size();i++){
            Interval inter = list.get(i);
            if(inter.start<pre.end)
                nextlist.add(inter);
            else
                pre = inter;
        }
        return helper(nextlist)+1;
    }
}


//alternative way without using Comparator Interface
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        //put start and end separately into two arrays
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        //sort two properties
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;//use end pointer to point to next 
        
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
}

//2. heap with priority queue O(nlogn)
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return 0;

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start==i2.start) return i1.end-i2.end;
                return i1.start - i2.start;
            }
        });
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Interval i:intervals){
            if(pq.isEmpty() || pq.peek()>i.start){
                count++;
            }else{
                pq.poll();
            }
            pq.offer(i.end);
        }
        return count;
    }
}