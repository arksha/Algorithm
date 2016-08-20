132. Palindrome Partitioning II

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

----------------------------------------------------------------------------------------
mantain two cache arrays, isPalin is to check each substring is palindrome,
min track number of min cut

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        boolean[][] isPalin = getisPalin(s);
        //min cut at postion i
        int[] min = new int[n + 1];
        min[0] = 0;
        
        for(int i = 0; i < n + 1; i++){
            min[i] = i - 1;
        }
        for(int i = 0;i< n + 1;i++){
            for(int j = 0;j < i;j++){
                if(isPalin[j][i - 1]){
                    min[i] = Math.min(min[i], min[j] + 1);
                }
            }
        }
        return min[n];
        
    }
    private boolean[][] getisPalin(String s){
        boolean[][] palin  = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            palin[i][i] = true;
        }
        for(int i = 0; i< s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                palin[i][i + 1] = true;
            }
        }
        for(int length = 2; length < s.length(); length++){
           for(int start = 0; start + length < s.length(); start++){
                if(palin[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length)){
                    palin[start][start + length] = true;
                }
           }
           
        }
        return palin;
    }
};