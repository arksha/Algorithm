60. Permutation Sequence

// The set [1,2,3,…,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note: Given n will be between 1 and 9 inclusive.

public class Solution {
    public String getPermutation(int n, int k) {
        //n! total permutations,after (n-1)! will change a start number
        //let k% (n-1)! permutation is current start index
        //use an array to store,and remove after each selection
        String res = "";
        
        ArrayList<Integer> nums = new ArrayList<>();
        int frac = 1;
        for(int i = 2;i<n;i++){//fraction calulate n!
            frac *= i;    
        }
        for(int i = 1;i<=n;i++){//array of numbers to select
            nums.add(i);
        }
        k--;//make index form 0 to n-1
        for(int i = n-1;i>=0;i--){
            int index = k/frac;
            k %=frac;
            res +=nums.get(index);
            nums.remove(index);
            if(i>0)
                frac /= i; 
        }
        return res;
    }
}