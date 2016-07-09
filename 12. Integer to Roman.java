// 12. Integer to Roman

// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.

// ------------------------------------------------------------------------------------------------------------------------
// set key number into array, when larger number comes, substract from num, till num is zero.

public class Solution {
    public String intToRoman(int num) {
        if(num<1||num>3999) return "";
        StringBuilder sb = new StringBuilder();

         int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
         String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
         for(int i = 0;i<val.length;i++){
             while(num>=val[i]){
                 num -=val[i];
                 sb.append(str[i]);
             }
         }
         return sb.toString();
    }
}

// reference: [http://www.blackwasp.co.uk/NumberToRoman.aspx]