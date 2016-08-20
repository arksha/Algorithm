Palindrome Partitioning


---------------------------------------------------------------------------
normal dfs
Analyze: 

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        List<String> list = new ArrayList<>();
        dfs(res, list, s, 0);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, String s, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i = pos; i < s.length(); i++){
            String suffix = s.substring(pos, i + 1);// NB: [pos, i]
            if(!isPalin(suffix)){
                continue;
            }
            list.add(suffix);
            dfs(res, list, s, i + 1);
            list.remove(list.size() - 1);
        }
    }
    private boolean isPalin(String s){
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
-----------------------------------------------------------------------------
use the way of Longest Palindrome substring 
to check substring is Palindrome.
this can cut some branch in dfs
O(n^2) 
though time complexity is not a big difference with first way, but still quicker
public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            return res;
        }
        boolean[][] ispal = new boolean[s.length()][s.length()];
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if((i + 1 >= j - 1 || ispal[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)){
                    ispal[i][j] = true;
                }
            }
        }
        dfs(res, new ArrayList<String>(), s, 0, ispal);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, String s, int pos, 
                    boolean[][] ispal){
        if(pos == s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i = pos; i < s.length(); i++){
            if(!ispal[pos][i]){
                continue;
            }
            list.add(s.substring(pos, i + 1));
            dfs(res, list, s, i + 1, ispal);
            list.remove(list.size() - 1);
        }
    }
}