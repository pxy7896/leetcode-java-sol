在给定的网格中，每个单元格可以有以下三个值之一：
	值 0 代表空单元格；
	值 1 代表新鲜橘子；
	值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

示例 1：
输入：[[2,1,1],[1,1,0],[0,1,1]]
输出：4

提示：
1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] 仅为 0、1 或 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotting-oranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
===================解法================
使用一个额外的数组记录橘子腐烂的时间。

class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
		int c = grid[0].length;
		int[][] times = new int[r][c];
		int cnt = 1;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 2)
					times[i][j] = 1;
				else
					times[i][j] = 0;
			}
		}
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (grid[i][j] == 2 && times[i][j] == cnt) {
          // 四个方向
						if (i > 0 && grid[i-1][j] == 1) {
							grid[i-1][j] = 2;
							times[i-1][j] = cnt+1;
							flag = true;
						}
						if (j > 0 && grid[i][j-1] == 1) {
							grid[i][j-1] = 2;
							times[i][j-1] = cnt+1;
							flag = true;
						}
						if (i < r-1 && grid[i+1][j] == 1) {
							grid[i+1][j] = 2;
							times[i+1][j] = cnt+1;
							flag = true;
						}
						if (j < c-1 && grid[i][j+1] == 1) {
							grid[i][j+1] = 2;
							times[i][j+1] = cnt+1;
							flag = true;
						}	
					}
				}
			}
			if (flag)
				cnt ++;
		}
    // 如果还有没有被波及的，返回-1
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1)
					return -1;
			}
		}
		return cnt - 1;
    }
}
