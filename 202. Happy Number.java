// 202. Happy Number.java

// getnext is to get the sum of the next number, generated from this stage square sum
// use HashSet to record sum had been calculated to avoid looping into the always cannot get 1 loop

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
            if(set.contains(n))
                return false; 
            set.add(n);
            n = getnext(n);
        }
        return true;
    }
    private int getnext(int n){
        int sum = 0;
        while(n!=0){
            sum += (n%10)*(n%10);
            n/=10;
        }
        return sum;
    }
}

// --------------------------------------------------------------------------------------------------------------
// a happier version for 5ms

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(set.add(n)){
            int sum = 0;
            if(n==1) return true;
            while(n!=0){
                sum+= (n%10) * (n%10);
                n /=10;
            }
            n = sum;
        }
        return false;
    }
}