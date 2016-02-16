305. Number of Islands II.java

public class Solution {
  int[] dx = {-1, 1, 0, 0};
  int[] dy = {0, 0, -1, 1};

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> res = new ArrayList<>();

    int count = 0;
    int[] nums = new int[m*n];
    Arrays.fill(nums, -1);

    for (int[] p : positions) {
      // for each position, mark it as new island
      int x = p[0]*n + p[1];
      nums[x] = x;
      count++;

      for (int i = 0; i < 4; i++) {
        // check neighbours
        int nx = p[0] + dx[i], ny = p[1] + dy[i], y = nx*n + ny;

        // ignore invalid position
        if (nx < 0 || nx >= m || ny < 0 || ny >= n || nums[y] == -1) continue;

        // find and union islands
        y = find(nums, y);
        x = find(nums, x);
        nums[y] = x;

        // merge two isolated islands
        if (y != x) count--;
      }

      res.add(count);
    }

    return res;
  }

  int find(int nums[], int i) {
    if (nums[i] == i) return i;
    nums[i] = find(nums, nums[i]);
    return nums[i];
  }

}