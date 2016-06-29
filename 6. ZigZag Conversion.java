// 6. ZigZag Conversion

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

// calculate step
// step for first and last row 2*(n-1)
// step1 in middle 2*(n-i-1)
// step2 in middle step-step1

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder sb = new StringBuilder();
        int step = 2*numRows -2;
        for(int i = 0;i < numRows;i++){
            if(i==0||i==numRows-1){
                for(int j = i;j<s.length();j += step ){
                    sb.append(s.charAt(j));
                }
            }else{
                int j = i;
                boolean flag = true;
                int step1 = 2*(numRows-i-1);
                int step2 = step-step1;
                while(j<s.length()){
                    sb.append(s.charAt(j));
                    if(flag==true){
                        j = j+ step1;
                    }else{
                        j = j + step2;
                    }
                    flag = !flag;
                }
            }
        }
        return sb.toString();
        
    }
}