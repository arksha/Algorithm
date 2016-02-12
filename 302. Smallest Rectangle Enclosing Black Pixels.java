302. Smallest Rectangle Enclosing Black Pixels.java

An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.

For example, given the following image:

[
  "0010",
  "0110",
  "0100"
]
and x = 0, y = 2,
Return 6.

//just to expand area of 1, using dfs
//use minx maxx miny maxy to update boundery, then search four directions

public class Solution {
    private int minx,maxx;
    private int miny,maxy;
    public int minArea(char[][] image, int x, int y) {
        int n = image.length;
        int m = image[0].length;
        if(image==null||n==0||m==0||image[x][y]!='1') return 0;
        minx = maxx = x;
        miny = maxy = y;
        dfs(image,x,y);
        return (maxx-minx+1)*(maxy-miny+1);
    }
    public void dfs(char[][] image, int x, int y){
        int n = image.length;
        int m = image[0].length;
        if(x<0||x>=n||y<0||y>=m||image[x][y]!='1') return;
        if(image[x][y]=='1'){
            image[x][y]='#';//visited
            minx = Math.min(x,minx);
            miny = Math.min(y,miny);
            maxx = Math.max(x,maxx);
            maxy = Math.max(y,maxy);
        }
        dfs(image,x-1,y);
        dfs(image,x,y-1);
        dfs(image,x+1,y);
        dfs(image,x,y+1);
        return;
    }
}