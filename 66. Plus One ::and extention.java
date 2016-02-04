66. Plus One //and extention
// Given a non-negative number represented as an array of digits, plus one to the number.

// The digits are stored such that the most significant digit is at the head of the list.

//basic depend on different conditions
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for(int i = digits.length-1;i>=0;i--){
            if(flag){
                
                if(digits[i]==9){
                    digits[i] = 0;
                    if(i ==0){
                        int[] arr = new int[digits.length+1];
                        arr[0] = 1;
                        for(int j = 1;j<arr.length;j++){
                            arr[j] = digits[digits.length-j];
                        }
                        return arr;
                    }
                    
                }else{
                    digits[i] = digits[i]+1;
                    flag = false;
                }
            }
        }
        return digits;
    }
}

// maintain a carry bit

public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length==0)  
        return digits;  
        int carry = 1;  
        for(int i=digits.length-1;i>=0;i--)  
        {  
            int digit = (digits[i]+carry)%10;   
            carry = (digits[i]+carry)/10;  
            digits[i] = digit;  
            if(carry==0)  
                return digits;      
        }  
        int [] res = new int[digits.length+1];      
        res[0] = 1;  
        return res;  
        }
}