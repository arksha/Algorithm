Merge k Sorted Arrays.java
Given k sorted integer arrays, merge them into one sorted array.

Example
Given 3 sorted arrays:
[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].

Challenge 
Do it in O(N log k).
N is the total number of integers.
k is the number of arrays.
--------------------------------------------------------------------------------------------------------------------------
A simple solution is to create an output array of size n*k and one by one copy all arrays to it. Finally, sort the output array using any O(nLogn) sorting algorithm. This approach takes O(nkLognk) time.

We can merge arrays in O(nk*Logk) time using Min Heap. Following is detailed algorithm.
1. Create an output array of size n*k.
2. Create a min heap of size k and insert 1st element in all the arrays into a the heap
3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted. If the array doesn’t have any more elements, then replace root with infinite. After replacing the root, heapify the tree.
     
class Nums{
    int row;
    int col;
    int val;
    public Nums(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    private Comparator<Nums> comparator = new Comparator<Nums>(){
        public int compare(Nums a, Nums b){
            return a.val - b.val;
        }
    };//NB: add ;
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0){
            return res;
        }
        if(arrays[0] == null || arrays[0].length == 0){
            return res;
        }
        //int totalSize = 0;
        PriorityQueue<Nums> minheap = new PriorityQueue<Nums>(arrays.length,comparator);
        for(int i = 0; i < arrays.length; i++){
            if(arrays[i].length > 0){// if array has elements
                minheap.offer(new Nums(i, 0, arrays[i][0]));
                //totalSize += arrays[i].length;
            }
        }
        while(!minheap.isEmpty()){
            Nums num = minheap.poll();
            res.add(num.val);
            if(num.col < arrays[num.row].length - 1){
                num.col += 1;
                num.val = arrays[num.row][num.col];
                minheap.offer(num);    
            }
        }
        return res;
    }
}  

Time Complexity: The main step is 3rd step, the loop runs n*k times. In every iteration of loop, we call heapify which takes O(Logk) time. Therefore, the time complexity is O(nk Logk).
