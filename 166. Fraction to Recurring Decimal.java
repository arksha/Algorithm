// 166. Fraction to Recurring Decimal.java

// should consider zero, negative, and overflow conditions

// case:

// zero                    0               
// negative                -1, -2
// Integer.MAX_VALUE       -1, -2147483648

// ----------------------------------------------------------------------------------------------------------------------
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

// ----------------------------------------------------------------------------------------------------------------------
// update version 21-Jun-2016:
// more consice
// remember turn into Long to avoid overflow

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        StringBuilder res = new StringBuilder();
        
        res.append(( (numerator>0) ^ (denominator>0) ) ? "-":""); 
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        res.append(num/den);
        num %= den;
        if(num==0)
            return res.toString();
          
        res.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(num,res.length());
        while(num!=0){
            num *=10;
            res.append(num/den);
            num %= den;
            if(map.containsKey(num)){
                int repeatIndex = map.get(num);
                res.insert(repeatIndex,"(");
                res.append(")");
                break;
            }
            map.put(num,res.length());
        }
        return res.toString();
    }
}
