// 252. Meeting Rooms.java

// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return false.

//check if intervals are overlapped
//usc Interface of Comparator, overwrite compare method

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
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals==null||intervals.length==0) return true;
        Arrays.sort(intervals,new IntervalComparator());
        
        Interval prev = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i].start < prev.end) return false;
            prev = intervals[i];
        }
        return true;
    }
}
class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b){
        if(a.start==b.start) return a.end - b.end;
        return a.start-b.start;
    }
}