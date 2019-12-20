给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

示例 1:
输入: 1
输出: "A"

示例 2:
输入: 28
输出: "AB"

示例 3:
输入: 701
输出: "ZY"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-title
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=========================解法================================
列表名称转数字很简单，数字转列表名称就要注意一下:先将n-1后再mod(26)
另外注意数字转char：(char)('A'+int)
因为'A'+int会转为int

class Solution {
    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        int temp = n;
        while(temp != 0) {
        	temp --;
        	s.append((char)('A'+temp%26));
        	temp /= 26;
        }
        return s.reverse().toString();
    }
}
