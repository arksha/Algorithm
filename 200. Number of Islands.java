200. Number of Islands.java

//1.dfs
public class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        if(grid==null||grid.length==0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid,int i,int j ){
        if(grid[i][j]=='0') return;
            
        grid[i][j]='0';
        if(i-1>=0) dfs(grid,i-1,j);
        if(i+1<grid.length) dfs(grid,i+1,j);
        if(j-1>=0) dfs(grid,i,j-1);
        if(j+1<grid[0].length) dfs(grid,i,j+1);
       
    }
}

//union find

public class Solution {
    public int numIslands(char[][] grid) {  
        if (grid == null || grid.length == 0 || grid[0].length == 0)  
            return 0;  
        initUnionFind(grid);  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (grid[i][j] == '0') continue;  
                if (j + 1 < n && grid[i][j + 1] == '1')  
                    union(i, j, i, j + 1);  
                if (i + 1 < m && grid[i + 1][j] == '1')  
                    union(i, j, i + 1, j);  
            }  
        }  
        int count = 0;  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (s[i][j] < 0)  
                    count++;  
            }  
        }  
        return count;  
    }  
    int[][] s;  
    int m, n;  
    public void initUnionFind(char[][] grid) {  
        m = grid.length;  
        n = grid[0].length;  
        s = new int[m][n];  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (grid[i][j] == '1')  
                    s[i][j] = -1;  
            }  
        }  
    }  
    public int find(int i, int j) {  
        if (s[i][j] < 0) {  
            return i * n + j;  
        } else {  
            return s[i][j] = find(s[i][j] / n, s[i][j] % n);  
        }  
    }  
    public void union(int i1, int j1, int i2, int j2) {  
        int root1 = find(i1, j1), root2 = find(i2, j2);  
        if (root1 == root2) return; // without this, fail @["111","111","111"]  
        int iRoot1 = root1 / n, jRoot1 = root1 % n;  
        int iRoot2 = root2 / n, jRoot2 = root2 % n;  
        if (s[iRoot1][jRoot1] < s[iRoot2][jRoot2]) {  
            s[iRoot2][jRoot2] = iRoot1 * n + jRoot1;  
        } else {  
            if (s[iRoot1][jRoot1] == s[iRoot2][jRoot2])  
                s[iRoot2][jRoot2]--;  
            s[iRoot1][jRoot1] = iRoot2 * n + jRoot2;  
        }  
    }  
}