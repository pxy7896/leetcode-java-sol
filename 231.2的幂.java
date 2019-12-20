给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

示例 1:
输入: 1
输出: true
解释: 2^0 = 1

示例 2:
输入: 16
输出: true
解释: 2^4 = 16

示例 3:
输入: 218
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-of-two
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
===========================解法================================
要点：n应该是正整数，测试用例里有负数：）
sol1:
public boolean isPowerOfTwo(int n) {
		if (n <= 0) return false;
		String s = Integer.toBinaryString(n);
		return s.lastIndexOf("1") == 0;
}
sol2: 位运算。n&(n-1) == 0
public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
}
