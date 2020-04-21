560. 和为K的子数组
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :
输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

说明 :
	数组的长度为 [1, 20,000]。
	数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
========================解法=============================
一次遍历，sum是前N项的和。用一个map记录，key是sum，value是次数。
当遍历到某位置i时，如果map中包含键sum-k，那么从当前位置到和为sum-k处，
数组和为sum-(sum-k) = k，有value次，所以要cnt += value。然后再将此时的
sum加入map。

class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
		    Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // 前面至少有一处，它之前的和为sum-k
            if (m.containsKey(sum - k))
                cnt += m.get(sum - k);
            // 再把sum添加进map
            if (m.containsKey(sum))
                m.put(sum, m.get(sum)+1);
            else
                m.put(sum, 1);
        }
		return cnt;
    }
}

类似的题目是
1248. 统计「优美子数组」

给你一个整数数组 nums 和一个整数 k。
如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
请返回这个数组中「优美子数组」的数目。

示例 1：
输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。

示例 2：
输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。

示例 3：
输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16

提示：
	1 <= nums.length <= 50000
	1 <= nums[i] <= 10^5
	1 <= k <= nums.length

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=============解法=========================
转换：奇数是1，偶数是0，和为k
这个转换可以用 nums[i] & 1 实现。

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int cnt = 0;
		Map<Integer, Integer> m = new HashMap<>();
        m.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]&1;
            if (m.containsKey(sum - k))
                cnt += m.get(sum - k);
            if (m.containsKey(sum))
                m.put(sum, m.get(sum)+1);
            else
                m.put(sum, 1);
        }
		return cnt;
    }
}
