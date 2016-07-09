// 13. Roman to Integer.java

// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

// -------------------------------------------------------------------------------------------------------------------------
// 1 - I 
// 2 - II
// 3 - III
// 4 - IV
// 5 - V
// 6 - VI
// 7 - VII
// 8 - VIII
// 9 - IX
// 10 - X
// 11 - XI
// 20 - XX
// 50 - L
// 100 - C 
// 500 - D 
// 1000 - M
// 1980 - MCMLXX
// -------------------------------------------------------------------------------------------------------------------------
// scan from tail to head, when s[i]'s corresbonding integer is bigger or equal than previous one, add into result, 
//otherwise substract from the result.

public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        if(s.length()==0||s==null) return res;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        char pre = s.charAt(s.length()-1);
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(map.get(c)>=map.get(pre)){
                res +=map.get(c);
            }else{
                res -=map.get(c);
            }
            pre = c;
        }
        return res;
    }
}

// -------------------------------------------------------------------------------------------------------------------------
// use switch, when get I X C those and be substract character, check if res for now is bigger than five times of those character, 
//if so, it needs to be replace by a new symbol and substract from res; otherwise just plus on the res.

public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        if(s.length()==0||s==null) return res;
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            switch(c) {
                case 'I':
                    res += 1* (res>=5?-1:1); 
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10*(res>=50?-1:1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100*(res>=500?-1:1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
                default:
                    break;
            }
        }
        return res;
    }
}
