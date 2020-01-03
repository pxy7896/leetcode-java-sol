编写一个程序，找出第 n 个丑数。丑数就是只包含质因数 2, 3, 5 的正整数。

示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

说明:  
	1 是丑数。
	n 不超过1690。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ugly-number-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==========================解法============================
丑数是递增排列的。

class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int idx2 = 0;
        int idx3 = 0;
        int idx5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(ans[idx2]*2, Math.min(ans[idx3]*3, ans[idx5]*5));
            if (min == ans[idx2]*2) idx2 ++;
            if (min == ans[idx3]*3) idx3 ++;
            if (min == ans[idx5]*5) idx5 ++;
            ans[i] = min;
        }
        return ans[n-1];
    }
}
