给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
如不存在这样的两个元素，请返回 -1。

示例 1：
输入：A = [34,23,1,24,75,33,54,8], K = 60
输出：58
解释：
34 和 24 相加得到 58，58 小于 60，满足题意。

示例 2：
输入：A = [10,20,30], K = 15
输出：-1
解释：
我们无法找到和小于 15 的两个元素。

提示：
	1 <= A.length <= 100
	1 <= A[i] <= 1000
	1 <= K <= 2000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum-less-than-k
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=============解法=============
排序，然后双指针。如果两指针之和大于K，则high前移，否则取相对大的那个值作为sum，并后移low。
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        if (A == null || A.length == 1) return -1;
		int sum = -1;
		Arrays.sort(A);
		int low = 0;
		int high = A.length-1;
		while (low < high) {
			if (A[low] + A[high] >= K) {
				high --;
			} else {
				sum = Math.max(sum, A[low] + A[high]);
				low ++;
			}
		}
		return sum;
    }
}
