// 166. Fraction to Recurring Decimal.java

// should consider zero, negative, and overflow conditions
// use HashMap to record whether fraction will recurse, key is remain, value is the position start remain

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        //if equals zero
        if(numerator==0) return "0";
        if(denominator==0) return "";
        //if negative
        if((numerator<0) ^ (denominator<0)) sb.append("-");
        //if overflow,should get into long first
        long num = numerator;
        num = Math.abs(num);
        long den = denominator;
        den = Math.abs(den);
        
        //dec part
        long dec = num/den;
        sb.append(dec);
        //if remain 0
        long remain = (num%den)*10;
        if(remain ==0) return sb.toString();
        
        //fraction part
        HashMap<Long,Integer> map = new HashMap<>();//key is remain, value is remain first appear position
        sb.append('.');
        while(remain!=0){
            if(map.containsKey(remain)){
                int start = map.get(remain);
                StringBuilder res = new StringBuilder();
                res.append(sb.substring(0,start) + "(" + sb.substring(start) + ")" );
                return res.toString();
            }
            //keep dividing
            map.put(remain,sb.length());
            dec = remain/den;
            sb.append(dec);
            remain = (remain%den)*10;
        }
        
        return sb.toString();
    }
}