// 263. Ugly Number I, [264] Ugly Number II [313] Super Ugly Number.java

// Write a program to check whether a given number is an ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

// Note that 1 is typically treated as an ugly number.
------------------------------------------------------------------------------------------------------------------
//just divide every factor and check if it is 1

public class Solution {
    public boolean isUgly(int num) {
        if(num <= 0){
            return false;
        }
        while(num % 2 == 0){
            num /= 2;
        } 
        while(num % 3 == 0) {
            num /= 3;
        }
        while(num % 5 == 0) {
            num /= 5;
        }
        if(num == 1) { 
            return true;
        }
        return false;
    }
}

// 264. Ugly Number II

// Write a program to find the n-th ugly number.

// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

// Note that 1 is typically treated as an ugly number.

// Hint:

// 1.The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
// 2.An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
// 3.The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
// 4.Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
---------------------------------------------------------------------------------------------------------------------

Here is a time efficient solution with O(n) extra space. The ugly-number sequence is 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
     because every number can only be divided by 2, 3, 5, 
     one way to look at the sequence is to split the sequence to three groups as below:
     (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
     (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
     (3) 1×5, 2×5, 3×5, 4×5, 5×5, …

     We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5. 
     Then we use similar merge method as merge sort, to get every ugly number from the three subsequence. 
     Every step we choose the smallest one, and move one step after.
     
public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];//record ith ugly number
        int[] index = new int[3];//count every prime factor used times
        int[] primes = {2,3,5};
        dp[0] = 1;
        for(int i = 1;i<n;i++){
            dp[i] = Math.min(Math.min(primes[0],primes[1]),primes[2]);
            
            if(dp[i]==primes[0]) primes[0] = 2*dp[++index[0]];
            if(dp[i]==primes[1]) primes[1] = 3*dp[++index[1]];
            if(dp[i]==primes[2]) primes[2] = 5*dp[++index[2]];
        }
        return dp[n-1];
    }
}

Update: use hash and heap O(nlogn)

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     * use hashset to avoid dup
     * heap store every ugly number
     * iterate 1 to n to find n ugly number, use former ugly number multiply
     * primes to get new ugly number and put into heap and hashset
     * 
     * NB: avoid large n exeed, use Long
     */
    public int nthUglyNumber(int n) {
        if(n == 0){
            return 0;
        }
        PriorityQueue<Long> minheap = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<Long>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        for(int i = 0; i < 3; i++){
            minheap.offer(primes[i]);
            set.add(primes[i]);
        }
            
        Long num = Long.valueOf(1);
        for(int i = 1; i < n; i++){
            num = minheap.poll();
            for(int j = 0; j < 3; j++){
                if(!set.contains(num * primes[j])){
                    minheap.offer(num * primes[j]);
                    set.add(num * primes[j]);
                }
            }
        }
        return num.intValue();
    }
};

// 313. Super Ugly Number

// Write a program to find the nth super ugly number.

// Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

// Note:
// (1) 1 is a super ugly number for any given primes.
// (2) The given numbers in primes are in ascending order.
// (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {//from super uglyII, use loop replace index 2,3,5
        int[] dp = new int[n];
        int[] index = new int[primes.length];
        dp[0] = 1;
        for(int i = 1;i<n;i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0;j<primes.length;j++){
                min = Math.min( dp[index[j]] * primes[j],min);
            }
            dp[i] = min;
            for(int j = 0;j<primes.length;j++){
                if(dp[i]%primes[j]==0) index[j]++;
            }
        }
        return dp[n-1];
    }
}
