给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

注意：
	num1 和num2 的长度都小于 5100.
	num1 和num2 都只包含数字 0-9.
	num1 和num2 都不包含任何前导零。
	你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
========================解法============================
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
		int carry = 0;
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		while (i >= 0 || j >= 0 || carry != 0) {
			if (i >= 0)
				carry += num1.charAt(i--) - '0';
			if (j >= 0)
				carry += num2.charAt(j--) - '0';
			s.append(carry % 10);
			carry /= 10;
		}
		return s.reverse().toString();
    }
}

类似的一题
989. 数组形式的整数加法
对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
示例 1：
输入：A = [1,2,0,0], K = 34
输出：[1,2,3,4]
解释：1200 + 34 = 1234

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
===================解法===========================
这里需要额外考虑addToArrayForm([0], 23)这种原数组过短的情况，所以K和A必须分别跟carry相加
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int carry = 0;
        int i = A.length - 1;
        List<Integer> result = new ArrayList<Integer>();
        while (K != 0 || i >= 0 || carry != 0) {
        	if (i >= 0)
        		carry += A[i--]; 
        	if (K != 0) {
        		carry += K % 10;
        		K /= 10;
        	}
        	result.add(carry % 10);
        	carry /= 10;
        }
        Collections.reverse(result); // 逆序List
        return result;
    }
}
