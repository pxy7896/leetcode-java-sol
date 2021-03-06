假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。

示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=========================解法===========================================
不用递归，因为担心数字太大。这里以空间换时间。dp[i]表示到第i级台阶的方法数，到第i级有两种方法：
1.到第i-1级，然后再走1级；
2.到第i-2级，然后再走2级。
所以dp[i] = dp[i-1] + dp[i-2]
初始时dp[1]=1, dp[2]=2(n是正整数，所以从1计)。

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
		int[] dp = new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
        return dp[n];
    }
}
//***********************************************************************
类似的题是746.使用最小花费爬楼梯
数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

示例 1:
输入: cost = [10, 15, 20]
输出: 15
解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。

示例 2:
输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
输出: 6
解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。

注意：
cost 的长度将会在 [2, 1000]。
每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
===========================解法========================================
f[i]表示从i级上到楼梯顶的花费，f[i] = cost[i]+min(f[i+1], f[i+2])
最后取min(f[0], f[1])
	
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] f = new int[cost.length];
        f[cost.length-1] = cost[cost.length-1];
        f[cost.length-2] = cost[cost.length-2];
        for (int i = cost.length-3; i >= 0; i--) {
        	f[i] = cost[i] + (f[i+1]>f[i+2]?f[i+2]:f[i+1]);
        }
        return f[0]>f[1]?f[1]:f[0];
    }
}
