Cavity Map

You are given a square map of size . Each cell of the map has a value denoting its depth. We will call a cell of the map a cavity if and only if this cell is not on the border of the map and each cell adjacent to it has strictly smaller depth. Two cells are adjacent if they have a common side (edge).

You need to find all the cavities on the map and depict them with the uppercase character X.

Input Format

The first line contains an integer, , denoting the size of the map. Each of the following  lines contains  positive digits without spaces. Each digit (1-9) denotes the depth of the appropriate area.

Constraints 

Output Format

Output  lines, denoting the resulting map. Each cavity should be replaced with character X.

Sample Input

4
1112
1912
1892
1234
Sample Output

1112
1X12
18X2
1234
Explanation

The two cells with the depth of 9 fulfill all the conditions of the Cavity definition and have been replaced by X.
---------------------------------------------------------------------------------------------------------------------------
brute force
check one by one

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String grid[] = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        String[] cavity = findCavity(grid, n);
        for(int i = 0; i < n; i++){
            System.out.println(cavity[i]);
        }
    }
    private static String[] findCavity(String[] grid, int n){
        String[] res = Arrays.copyOf(grid, n);
        if(grid == null || n == 0){
            return res;
        }  
        for(int i = 1; i < n - 1; i++){
            for(int j = 1; j < n - 1; j++){
                if(isCavity(grid, n, i, j)){
                    char[] c = Arrays.copyOf(res[i].toCharArray(), res[i].toCharArray().length);
                    c[j] = 'X';
                    res[i] = String.valueOf(c); 
                }
            }
        }
        return res;
    }
    private static boolean isCavity(String[] grid, int n, int i, int j){
        int depth = Character.digit(grid[i].charAt(j), 10);
        int up = Character.digit(grid[i - 1].charAt(j), 10);
        int down = Character.digit(grid[i + 1].charAt(j), 10);
        int left = Character.digit(grid[i].charAt(j - 1), 10);
        int right = Character.digit(grid[i].charAt(j + 1), 10);
        if(depth <= up || depth <= down || depth <= left || depth <= right){
            return false;
        }
        return true;
    }
   
}
