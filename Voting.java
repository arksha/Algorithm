Voting

It’s election time in Byteland.  citizens casted one vote for one person. To win the election, a candidate must earn more votes than half of the total number of voters.

Challenge: Who won the election? It’s guaranteed that, for the given input, there will always be a winner.

Input Format

The first line of input contains a single integer , denoting the number of citizens.
The th line of the following  lines contains a lowercase English letter string, denoting the candidate who gets the vote of the th citizen.

Constraints
1 <= M <= 10^3
Each name consists of  to  lowercase English letters.
Citizens can only vote for existing candidates.
Output Format

First and only line of output: the name (in lowercase English letters) of the winning candidate.

Sample Input

5
jack
john
jake
john
john
Sample Output

john
Explanation

The candidate named "john" gets  votes, which is larger than half of the number of voters.
---------------------------------------------------------------------------------------------------------
sort and keep in hashmap, iterate hashmap O(nlogn)
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] candidates = new String[n];
        for(int i = 0; i < n; i++){
            candidates[i] = in.next();
        }
        Arrays.sort(candidates);
        String winner = voting(candidates, n);
        for(int i = 0; i < n; i++){
           System.out.println(candidates[i]);
        }
        
        System.out.println(winner);
    }
    private static String voting(String[] candidates, int n){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(candidates[i])){
                map.put(candidates[i],1);
            }else{
                map.put(candidates[i], map.get(candidates[i]) + 1);
            }
        }
        int maxvote = Integer.MIN_VALUE;
        String maxcandi = new String();
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxvote){
                maxvote = entry.getValue();   
                maxcandi = entry.getKey();
            }
        }
        return maxcandi;
    }
}
