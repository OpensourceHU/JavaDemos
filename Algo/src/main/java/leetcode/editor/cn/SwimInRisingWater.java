//在一个 N x N 的坐标方格 grid 中，每一个方格的值 grid[i][j] 表示在位置 (i,j) 的平台高度。 
//
// 现在开始下雨了。当时间为 t 时，此时雨水导致水池中任意位置的水位为 t 。你可以从一个平台游向四周相邻的任意一个平台，但是前提是此时水位必须同时淹没这两
//个平台。假定你可以瞬间移动无限距离，也就是默认在方格内部游动是不耗时的。当然，在你游泳的时候你必须待在坐标方格里面。 
//
// 你从坐标方格的左上平台 (0，0) 出发。最少耗时多久你才能到达坐标方格的右下平台 (N-1, N-1)？ 
//
// 
//
// 示例 1: 
//
// 
//输入: [[0,2],[1,3]]
//输出: 3
//解释:
//时间为0时，你位于坐标方格的位置为 (0, 0)。
//此时你不能游向任意方向，因为四个相邻方向平台的高度都大于当前时间为 0 时的水位。
//
//等时间到达 3 时，你才可以游向平台 (1, 1). 因为此时的水位是 3，坐标方格中的平台没有比水位 3 更高的，所以你可以游向坐标方格中的任意位置
// 
//
// 示例2: 
//
// 
//输入: [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6
//]]
//输出: 16
//解释:
// 0  1  2  3  4
//24 23 22 21  5
//12 13 14 15 16
//11 17 18 19 20
//10  9  8  7  6
//
//最终的路线用加粗进行了标记。
//我们必须等到时间为 16，此时才能保证平台 (0, 0) 和 (4, 4) 是连通的
// 
//
// 
//
// 提示: 
//
// 
// 2 <= N <= 50. 
// grid[i][j] 是 [0, ..., N*N - 1] 的排列。 
// 
// Related Topics 堆 深度优先搜索 并查集 二分查找 
// 👍 164 👎 0

package leetcode.editor.cn;

public class SwimInRisingWater {
  public static void main(String[] args) {
    Solution solution = new SwimInRisingWater().new Solution();
    System.out.println(solution.swimInWater(new int[][] {{3, 2}, {0, 1}}));
  }

  //leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    int N;
    int[] di = {0, -1, 0, 1};
    int[] dj = {-1, 0, 1, 0};

    boolean dfs(int i, int j, boolean[][] isValid, boolean[][] vis) {
      if (i == j && i == N - 1) {
        return true;
      }
      if (isValid[i][j] == false) {
        return false;
      }
      vis[i][j] = true;
      boolean ret = false;
      for (int k = 0; k < 4; k++) {
        int nextI = di[k] + i;
        int nextJ = dj[k] + j;
        if (nextI >= 0 && nextI < N && nextJ >= 0 && nextJ < N &&
            isValid[nextI][nextJ] == true && vis[nextI][nextJ] == false) {
          ret |= dfs(nextI, nextJ, isValid, vis);
        }
      }
      return ret;
    }

    public int swimInWater(int[][] grid) {
      N = grid.length;
      int max = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          max = Math.max(grid[i][j], max);
        }
      }
      int L = 0;
      int R = N * N;

      while (L + 1 < R) {
        int mid = (L + R) >> 1;
        boolean[][] isValid = new boolean[N][N];
        boolean[][] vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
            if (grid[i][j] <= mid) {
              isValid[i][j] = true;
            }
          }
        }
        boolean ans = dfs(0, 0, isValid, vis);
        if (ans) {
          R = mid;
        } else {
          L = mid;
        }
      }
      return R;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}