给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。

示例1:
输入: 5
输出: True
解释: 1 * 1 + 2 * 2 = 5

示例2:
输入: 3
输出: False

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-square-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
========================解法=====================================
双指针
public boolean judgeSquareSum(int c) {
        int slow = 0;
        int fast = (int)Math.sqrt(c); // 从平方根处开始
        int sum = 0;
        while (slow <= fast && fast > -1) {
        	sum = slow*slow + fast*fast;
        	if (sum == c)
        		return true;
        	else if (sum > c)
        		fast --;
        	else
        		slow ++;
        }
        return false;
    }
