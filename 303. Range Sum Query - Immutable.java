303. Range Sum Query - Immutable.java

//dp
//array[i] is sum before index i

public class NumArray {//DP
    private int[] array;
    public NumArray(int[] nums) {
        array = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            array[i+1] = array[i]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return array[j+1]-array[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);