给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。

示例 1：
输入: num = 1775(110111011112)
输出: 8

示例 2：
输入: num = 7(01112)
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-bits-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=================解法==========================
用一个数组记录到目前为止的1的个数。只能翻转1位，所以要求两块只隔1个0的“1”块的长度。
class Solution {
    public int reverseBits(int num) {
        int[] cnt = new int[1000];
        int idx = 0;
        int max = 0;
        while (num > 0) {
            if (num % 2 == 1)
                cnt[idx] ++;
            else
                idx ++;
            num /= 2;
        }
        for (int i = 0; i <= idx; i++) {
            if (max < cnt[i] + cnt[i+1] + 1)
                max = cnt[i] + cnt[i+1] + 1;
        }
        return max;
    }
}
