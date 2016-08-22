Merge Two Sorted Arrays
 
Merge two given sorted integer array A and B into a new sorted integer array.

Example
A=[1,2,3,4]
B=[2,4,5,6]
return [1,2,2,3,4,4,5,6]

Challenge 
How can you optimize your algorithm if one array is very large and the other is very small?
--------------------------------------------------------------------------------

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] res = new int[A.length + B.length]; 
        int pa = 0;
        int pb = 0;
        int index = 0;
        
        while(pa < A.length && pb < B.length){
            if (A[pa] <= B[pb]){
                res[index++] = A[pa++];
            }else {
                res[index++] = B[pb++];
            }
        }
        while(pb < B.length){
            res[index++] = B[pb++];
        }
        while(pa < A.length){
            res[index++] = A[pa++];
        }
        return res;
    }
}
