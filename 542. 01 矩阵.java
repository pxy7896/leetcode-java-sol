给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。

示例 1: 
输入:
0 0 0
0 1 0
0 0 0
输出:
0 0 0
0 1 0
0 0 0

示例 2: 
输入:
0 0 0
0 1 0
1 1 1
输出:
0 0 0
0 1 0
1 2 1

注意:
	给定矩阵的元素个数不超过 10000。
	给定矩阵中至少有一个元素是 0。
	矩阵中的元素只在四个方向上相邻: 上、下、左、右。
  
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/01-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==================解法===============
class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] != 0)
                // 可能有+1的情况，要防溢出
                    ans[i][j] = Integer.MAX_VALUE-1;
                else
                    ans[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                // 向左
                if (i-1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i-1][j] + 1);
                }
                // 向上
                if (j-1 >= 0) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j-1] + 1);
                }
            }
        }
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0 ; j--) {
                // 向右
                if (i+1 < m) {
                    ans[i][j] = Math.min(ans[i][j], ans[i+1][j] + 1);
                }
                // 向下
                if (j+1 < n) {
                    ans[i][j] = Math.min(ans[i][j], ans[i][j+1] + 1);
                }
            }
        }

        return ans;
    }
}
