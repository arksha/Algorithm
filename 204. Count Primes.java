// 204. Count Primes

// brute force
// check every number is prime then count prime number.
// O(n^2) TLE

public class Solution {
    public int countPrimes(int n) {
        if(n <= 0) return 0; 
        int res = 0;//1 is prime
        for(int i = 2;i<n;i++){
            if(isPrime(i)) res++;
        }
        return res;
    }
    public boolean isPrime(int n){
            //change this loop into i<=n/2 still get TLE
            //As we know the number must not be divisible by any number > n / 2, 
            //we can immediately cut the total iterations half by dividing only up to n / 2.
            //change loop into i*i<=n will make O(n^1.5) but still can improve
        for(int i = 2;i<n;i++){
            if(n%i==0)
            return false;
        }
        return true;
    }
}
//------------------------------------------------------------------------------------------
// Sieve of Eratosthenes(fill table, Hashtable)
//fill every factor and its multiply, only need to fill till sqrt(n)
//fill loop start from i*i and increase by i every time, 
O(nlog(logn))

public class Solution {
    public int countPrimes(int n) {
        int[] table = new int[n];
        for(int i = 2;i*i<n;i++){
            if(table[i]==0){
                for(int j = i*i;j<n;j +=i) table[j] = 1;
            }  
        }
        int res = 0;
        for(int i = 2;i<n;i++){
            if(table[i]==0) res++;
        }
        return res;
    }
}