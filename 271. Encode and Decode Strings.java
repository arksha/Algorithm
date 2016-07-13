//271. Encode and Decode Strings.java

// Design an algorithm to encode a list of strings to a string. 
//The encoded string is then sent over the network and is decoded back to the original list of strings.

// Machine 1 (sender) has the function:

// string encode(vector<string> strs) {
//   // ... your code
//   return encoded_string;
// }
// Machine 2 (receiver) has the function:
// vector<string> decode(string s) {
//   //... your code
//   return strs;
// }
// So Machine 1 does:

// string encoded_string = encode(strs);
// and Machine 2 does:

// vector<string> strs2 = decode(encoded_string);
// strs2 in Machine 2 should be the same as strs in Machine 1.

// Implement the encode and decode methods.

// Note:
// The string may contain any possible characters out of 256 valid ascii characters. 
// Your algorithm should be generalized enough to work on any possible characters.
// Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
// Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.

//1.use delimeter like "#"
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            int len = s.length();//record every string lens
            sb.append(len).append("#").append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        if(s==null|s.length()==0) return res;
        
        int i = s.indexOf("#");
        int len = Integer.valueOf(s.substring(0,i));
        String str = s.substring(i+1,i+len+1);
        res.add(str);
        res.addAll(decode(s.substring(i+len+1)));
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));


//2.use format and "%4d" represent string size

//do not use delimeter,instead , use protocol encode ways
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        int n = strs.size();
        res.append(String.format("%4d",n));//use format, use 4 bit to represent every string size
        
        for(String str: strs){
            int len = str.length();
            String strlen = String.format("%4d",len);
            res.append(strlen);
            res.append(str);
        }
        return res.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int total = Integer.valueOf(s.substring(0,4).trim());//get total number of string
        int offset = 4;//offset
        
        for(int i =0;i<total;i++){
            String strlen = s.substring(offset,offset+4);//get string length
            int len = 0;
            if(!strlen.trim().equals("")){//this string is not empty
                len = Integer.valueOf(strlen.trim());//have length
            }
            offset +=4;//go to string self part
            if(len==0){//string is empty
                res.add("");
            }else{
                res.add(s.substring(offset,offset+len));
            }
            offset +=len;//goto next string
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));