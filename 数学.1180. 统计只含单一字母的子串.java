给你一个字符串 S，返回只含 单一字母 的子串个数。

示例 1：
输入： "aaaba"
输出： 8
解释： 
只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
"aaa" 出现 1 次。"aa" 出现 2 次。"a" 出现 4 次。"b" 出现 1 次。
所以答案是 1 + 2 + 4 + 1 = 8。

示例 2:
输入： "aaaaaaaaaa"
输出： 55

提示：
	1 <= S.length <= 1000
	S[i] 仅由小写英文字母组成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-substrings-with-only-one-distinct-letter
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==============解法==================
查找由单一字符组成的所有子串，每个子串直接就长度取组合即可。
class Solution {
    public int countLetters(String S) {
        char[] c = S.toCharArray();
        int ans = 0;
        for (int i = 0, j = 0; i < c.length; i = j) {
            i = j;
            while (j < c.length && c[i] == c[j]) // 注意j的范围！！
                j ++;
            ans += (j - i) * (j - i + 1) / 2; // 这里j-i相当于n
        }
        return ans;
    }
}
