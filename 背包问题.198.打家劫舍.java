你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:
输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2:
输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
===============================解法===================================
用dp记录到每个位置的最大金额。每次计算都只有两种可能：
1.跳过这个位置，则dp[i] = dp[i-1]
2.抢这个位置，那就要用前前一个的值：dp[i] = dp[i-2] + nums[i-1]。注意这里dp中的i对应的是nums中的i-1
每次都要取这两种可能的最大值。

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0; // 空数组用例
        if (nums.length == 1) return nums[0]; // 单个
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        } 
        return dp[nums.length];
    }
}
=======================另一种解法=======================
只用变量记住值就可以了
class Solution {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i : nums) {
            int c = Math.max(a+i, b);
            a = b;
            b = c;
        }
        return b;
    }
}
