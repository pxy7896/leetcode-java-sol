给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
更正式地，检查是否存在两个下标 i 和 j 满足：
	i != j
	0 <= i, j < arr.length
	arr[i] == 2 * arr[j]

示例 1：
输入：arr = [10,2,5,3]
输出：true
解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。

示例 2：
输入：arr = [7,1,14,11]
输出：true
解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。

示例 3：
输入：arr = [3,1,7,11]
输出：false
解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。

提示：
	2 <= arr.length <= 500
	-10^3 <= arr[i] <= 10^3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-if-n-and-its-double-exist
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=============解法=====================
这题的坑在于，如果是排序，然后找是否有两倍数的时候，对于含负值的数组，会很麻烦。
所以正解是直接利用set。直接检查集合中是否有一个数的两倍或是其0.5倍的数值。
class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> s = new HashSet<>();
		for (int num:arr) {
			if (s.contains(num*2) || (num%2==0 && s.contains(num/2)))
				return true;
			s.add(num);
		}
		return false;
    }
}
