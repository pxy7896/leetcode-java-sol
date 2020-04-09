给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
================解法====================
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(res, 0, 0, n, "");
        return res;
    }
    // cnt1记录"("的数目，cnt2记录")"的数目
    void helper(List<String>res, int cnt1, int cnt2, int n, String str) {
        if (cnt1 > n || cnt2 > n)
            return;
        if (cnt1 == n && cnt2 == n) {
            res.add(str);
            return; // 加上节省时间
        }
        if (cnt1 >= cnt2) {
            String temp = new String(str);
            helper(res, cnt1+1, cnt2, n, temp+"(");
            helper(res, cnt1, cnt2+1, n, temp+")");
        }
    }
}
