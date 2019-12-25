给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:
输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
========================解法===============================
设置curSum和maxSum，curSum选nums[i](重新开始计算curSum，即新的子序列)和curSum+nums[i]中的最大值；
maxSum则记录全局最大值。
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	curSum = Math.max(nums[i], nums[i]+curSum);
        	maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
