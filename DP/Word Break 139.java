139. Word Break 
Difficulty: Medium
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

-------------------------------------------------------------------------------------------------
when get this yes or no problem can use DFS to search in brute force first, but this cost a lot.
So we could use boolean[] dp to record some intermediate result.
--------------------------------------------------------------------------------
DP approach take too long time 
1. state boolean[] dp
	S[0,i-1] can be break
2. fuctioin
	dp[i] true if 
		dp[j] is true and substring(j,i) is in dictionay
		substring(0, i) is in dictionay
	false if 
		no such j exist

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        //default is false
        boolean[] dp = new boolean[n + 1];
        //empty string is valid
        dp[0] = true;
        //from "a" "ab" "abc" to "abcde"
        for(int i = 1;i < n + 1;i++){
            for(int j = 0; j < i;j++){
                if(dp[j] == false){
                    continue;
                }
                //get j to i-1 substring
                String sub = s.substring(j,i);
                if(wordDict.contains(sub)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];   
    }
}

The second loop could count from i - 1 to 0 will better, because after you processed a few words, it is likely that the match word will be found at the end of the finished part of the string, but not a really long word which begins from the beginning of the string

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        
        boolean[] dp = new boolean[n + 1];
       
        dp[0] = true;
      
        for(int i = 1;i < n + 1;i++){
            for(int j = i - 1; j >= 0;j--){
                if(dp[j] == false){
                    continue;
                }
                String sub = s.substring(j,i);
                if(wordDict.contains(sub)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];   
    }
}

add a method to find max lenghth word in worddict, this will cut some branches when searching from i - 1 to the previous one.

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = true;
        int maxlength = maxLength(dict);
        for(int i = 1;i < n + 1;i++){
            for(int j = 1; j <= i && j <= maxlength; j++){
                if(dp[i - j] == false){
                    continue;
                }
                
                String sub = s.substring(i - j,i);
                if(dict.contains(sub)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
    private int maxLength(Set<String> dict){
        int maxlength = 0;
        for(String word: dict){
            maxlength = Math.max(maxlength, word.length());
        }
        return maxlength;
    }
}

