给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。

示例 1：
输入：[-4,-1,0,3,10]
输出：[0,1,9,16,100]

示例 2：
输入：[-7,-3,2,3,11]
输出：[4,9,9,49,121]

提示：
	1 <= A.length <= 10000
	-10000 <= A[i] <= 10000
	A 已按非递减顺序排序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==========================解法=================================
由于数组是有序的，那么绝对值也是先递减再递增的，所以只需要比较两端中哪个绝对值大，再将其平方值填入结果。
如果右侧比左侧大，那么填入右侧的平方值，然后左侧指针保持不动，右侧--（当前右侧指针已经处理完毕）；
如果左侧比右侧大，那么填入左侧的平方值，然后右侧指针保持不动，左侧++（当前左侧指针已经处理完毕）。
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        int now = right;
        while (left <= right) {
        	int numLeft = A[left]<0 ? -A[left] : A[left];
        	int numRight = A[right]<0 ? -A[right] : A[right];
        	if (numLeft > numRight) {
        		result[now--] = numLeft * numLeft;
        		left ++;
        	} else {
        		result[now--] = numRight * numRight;
        		right --;
        	}
        }
        return result;
    }
}
