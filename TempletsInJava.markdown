#Templets in Java#

##1.Collections

###1.Queue
 
	Queue<Integer> queue = new LinkedList<>();
	queue.offer(i);
	int i = queue.poll();
	queue.peek();
	
	//below will return a special number
	queue.add();
	queue.remove();
###2.PriorityQueue
	PriorityQueue<> pq = new PriorityQueue<>();

###3.String
	s = s.trim();
	s = s.toLowerCase();
	char[] = s.split(" ");
###4.Character
	Character.isDigit( c );
	Character.isLetterorDigit( c );
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
###2.Iterator
	Iterator<T> it = new Iterator<>();
	it.next();
	it.hasnext();

##3.Sorting
###1.Quick Sort

	public class QuickSort{
		int Partition(int arr[], int left,int right){
			int i = left, j = right;
			int pivot = arr[(left+right)/2];
			while(i<=j){
				while(arr[i]<pivot){ i++; }
				while(arr[j]>pivot){ j--; }
				if(i<=j){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
				}
			}
			return i;
		}
		
		void QuickSort(int arr[],int left,int right){
			int index = Partition(arr,left,right);
			if(left<index-1)
				quickSort(arr,left,index-1);
			if(index<right)
				quickSort(arr,index,right);
		}
	}
###2.Bucket Sort
