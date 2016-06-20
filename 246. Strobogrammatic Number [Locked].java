// 246. Strobogrammatic Number [Locked]

// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Write a function to determine if a number is strobogrammatic. The number is represented as a string.

// For example, the numbers "69", "88", and "818" are all strobogrammatic.

// ------------------------------------------------------------------------------------------------------------------------------------
// convert the strings with pattern 
// 0->0
// 1->1
// 6->9
// 8->8
// 9->6
// and check if contverted string is the same as before


	// public class Solution {
 //    public boolean isStrobogrammatic(String num) {
 //        StringBuilder s = new StringBuilder();
 //        for(int i = 0;i<num.length();i++){
 //            char c = num.charAt(i);
 //            switch(c){
 //                case '1': c = '1'; break;
 //                case '6': c = '9';break;
 //                case '9': c = '6';break;
 //                case '8': c = '8';break;
 //                case '0': c = '0';break;
 //                default: return false;
 //            }
 //            s.append(c);
 //        }
 //        return s.reverse().toString().equals(num);
 //    }
	// }


// second way to use HashMap and check from two sides to middle
public class Solution {
    public boolean isStrobogrammatic(String nums){
        HashMap<Character,Character> map  = new HashMap<>();
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        map.put('0','0');
        for(int i = 0;i<nums.length()/2;i++){
            if(!map.containsKey(nums.charAt(i)) || 
                nums.charAt(i)!= nums.charAt(nums.length()-1-i)) return false;
        }
        return true;
    }
}