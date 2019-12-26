平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
你可以按照下面的规则在平面上移动：
每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
必须按照数组中出现的顺序来访问这些点。

输入：points = [[1,1],[3,4],[-1,0]]
输出：7
解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]   
从 [1,1] 到 [3,4] 需要 3 秒 
从 [3,4] 到 [-1,0] 需要 4 秒
一共需要 7 秒

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-time-visiting-all-points
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=========================解法======================================
设点(xi, yi)与(xj, yj)之间的距离有dx=|xi - xj|和dy=|yi - yj|
讨论：
1) 当dy > dx时，移动顺序应为先沿对角线方向移动dx，再沿垂直方向移动(dy-dx)，所以共移动dy
2) 当dy = dx时，只沿对角线方向移动，即dy
3) 当dy < dx时，移动顺序应先沿对角线方向移动dy，再沿水平方向移动(dx-dy)，所以共移动dx
综上，每次移动的实际最小距离应该是max(dy, dx)
所以只要遍历数组，求这个值的和即可。
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 1) return 0;
	int sum = 0;
	int preX = points[0][0];
	int preY = points[0][1];
	for (int i = 1; i < points.length; i++) {
		sum += Math.max(Math.abs(points[i][0]-preX), Math.abs(points[i][1]-preY));
		preX = points[i][0];
		preY = points[i][1];
	}
	return sum;
    }
}
