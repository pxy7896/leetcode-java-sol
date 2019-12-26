给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
如果 S[i] == "I"，那么 A[i] < A[i+1]
如果 S[i] == "D"，那么 A[i] > A[i+1]

示例 1：
输出："IDID"
输出：[0,4,1,3,2]

示例 2：
输出："III"
输出：[0,1,2,3]

示例 3：
输出："DDI"
输出：[3,2,0,1]

提示：
	1 <= S.length <= 1000
	S 只包含字符 "I" 或 "D"。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-string-match
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
======================解法===================================
每一步，如果是"I"就挑当前最小值；如果是"D"，就挑当前最大值。开始的时候取值范围是0~N
class Solution {
    public int[] diStringMatch(String S) {
        int min = 0;
        int max = S.length();
        int[] result = new int[max+1];
        for (int i = 0; i < S.length(); i++) {
        	if (S.charAt(i) == 'I') {
        		result[i] = min;
        		min ++;
        	} else {
        		result[i] = max;
        		max --;
        	}
        }
        result[S.length()] = min;
        return result;
    }
}
