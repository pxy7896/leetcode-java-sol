给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

示例 1:
输入: S = "loveleetcode", C = 'e'
输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

说明:
	字符串 S 的长度范围为 [1, 10000]。
	C 是一个单字符，且保证是字符串 S 里的字符。
	S 和 C 中的所有字母均为小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
===========================解法=======================================
首先计算在S中，前两个C的位置，分别为left和right。因为right不一定存在，如果right不存在，那么result的每个值就是
每个位置与left的绝对距离。如果right存在，那么就要更新为当前位置与left和right的绝对距离的最小值。如果当前位置就是
right，那么它的绝对距离应该是0，再更新为left，继续找下一个right。

class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        int l = S.indexOf(C);
        int r = S.indexOf(C, l + 1); //如果这里写L，那么会返回L
        for (int i = 0; i < S.length(); i++) {
        	result[i] = Math.abs(l - i);
        	if (r != -1) {
        		result[i] = Math.min(result[i], r - i);
        		if (r == i) {
        			result[i] = 0;
        			l = r;
        			r = S.indexOf(C, r + 1);
        		}
        	}
        }
        return result;
    }
}
