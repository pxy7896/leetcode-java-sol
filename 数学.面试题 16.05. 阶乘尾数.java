设计一个算法，算出 n 阶乘有多少个尾随零。

示例 1:
输入: 3
输出: 0
解释: 3! = 6, 尾数中没有零。

示例 2:
输入: 5
输出: 1
解释: 5! = 120, 尾数中有 1 个零.

说明: 你算法的时间复杂度应为 O(log n) 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/factorial-zeros-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
============解法====================
末尾的0是2*5形成的，只要是偶数，就会有一个2，所以2足够多，只需要计算5的个数就行了。
每次除以5，计算其中5的数目。
class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += n / 5;
            n /= 5;
        }
        return cnt;
    }
}
