#Templets in Java#

##1.Collections

###1.Queue
 
		//implement: can use LinkedList
		Queue<Integer> queue = new LinkedList<>();
		//inqueue:
		queue.offer(i);
		//dequeue:
		int i = queue.poll();
		//get top:
		queue.peek();
		
		//below will return a special number
		queue.add();
		queue.remove();
##2.Interfaces

###1.Comparator

Can sort multiple property if needed.

Only one property can use Interface **Comparable**, overwrite **compareTo()** method

	class MyComparator implements Comparator<Interval>{
		//compare m-n>0 return positive, or negetive 
		public int compare(Interval m, Interval n){
			if(m.start==n.start) 
				return m.end-n.end;
		}
		
	}
	
use MyComparator;
	
	Arrays.sort(intervals, new MyComparator());

