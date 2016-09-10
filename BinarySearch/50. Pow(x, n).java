50. Pow(x, n)
remember consider case n = -1

public class Solution {
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        if(n == -1){
            return 1 / x;
        }
        double val = myPow(x, n / 2);
        return val * val * myPow(x, n % 2);
    }
}
