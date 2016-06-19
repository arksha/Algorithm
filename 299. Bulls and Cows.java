299. Bulls and Cows.java

public class Solution {
    public String getHint(String secret, String guess) {
        int[] map = new int[10];
        int bull = 0, cow  = 0;
        for(int i = 0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)) bull++;
            else{
                if(map[secret.charAt(i)-'0']++<0) cow++;
                if(map[guess.charAt(i)-'0']-->0) cow++;
            }
        }
        return bull+ "A" + cow + "B";
    }
}