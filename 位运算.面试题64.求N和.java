求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

示例 1：
输入: n = 3
输出: 6
示例 2：
输入: n = 9
输出: 45

限制：
	1 <= n <= 10000
  
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/qiu-12n-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
====================解法=====================
使用求和公式：sum = n*(n+1)/2，除以2可以用右移，因为一定是偶数
class Solution {
    public int sumNums(int n) {
        return (int)(Math.pow(n, 2)+n)>>1;
    }
}
