// Search in a Big Sorted Array

// Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

// Return -1, if the number doesn't exist in the array.

//  Notice

// If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.


// Example
// Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

// Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.

// Challenge 
// O(log k), k is the first index of the given target number.

// ------------------------------------------------------------------------------------------
// 1. use index to increase to most close to target place by multiple 2 every time -> to find the high place
// 2. do Binary search between 0 and index

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if (reader == null) {
            return -1;
        }
        int index = 1;
        while (reader.get(index-1) < target){// make sure to include target 
            index *= 2;
        }
        int low = 0, high = index-1;
        
        while (low + 1 < high){
            int mid = low + (high - low) / 2;
            if (reader.get(mid) < target) {
                low = mid;
            }else {
                high = mid;
            }
        }
        if (reader.get(low) == target){
            return low;
        } else if (reader.get(high) == target){
            return high;
        }else {
            return -1;
        }
    }
}