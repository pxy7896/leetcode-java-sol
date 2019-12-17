给定两个二进制字符串，返回他们的和（用二进制表示）。
输入为非空字符串且只包含数字 1 和 0。
示例 1:
输入: a = "11", b = "1"
输出: "100"

示例 2:
输入: a = "1010", b = "1011"
输出: "10101"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-binary
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

========解法=======================================
模拟按位计算，从后往前。首先计算每位的和sum(00,01,10,11)，与1做&运算可以得到该位实际的和。sum右移一位再与1做&运算可以得到进位的值carry。
最后，carry如果不是0，要在结果首位补一个carry。
涉及的知识点：位运算>>和&，StringBuilder的toString，String的charAt(i)
其中>>指向右移位，>>>指无符号右移，忽略符号位，空位都以0补齐。

package hello;

public class Test {
	public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i > -1 || j > -1) {
        	int na = i > -1 ? a.charAt(i)-'0' : 0;
        	int nb = j > -1 ? b.charAt(j)-'0' : 0;
        	int sum = na + nb + carry;
        	result.insert(0, sum & 1);
        	carry = (sum >> 1) & 1;
        	i --;
        	j --;
        }
        if (carry != 0) {
        	result.insert(0, carry);
        }
        return result.toString();
    }
		  
	public static void main(String[] args) {
		System.out.println(new Test().addBinary("1010", "1011"));
	}
}
