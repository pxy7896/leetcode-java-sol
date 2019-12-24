不使用运算符 + 和 - ，计算两整数a 、b之和。

示例 1:
输入: a = 1, b = 2
输出: 3

示例 2:
输入: a = -2, b = 3
输出: 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-two-integers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
============================解法========================
class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
        	int res = (a & b) << 1;
        	a = a ^ b;
        	b = res;
        	//System.out.println("a:"+String.valueOf(a) + "\tb:" + String.valueOf(b));
        }
        return a;
    }
}
