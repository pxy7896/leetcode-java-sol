如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

示例 1：
输入：[1,2,5,9,5,9,5,5,5]
输出：5

示例 2：
输入：[3,2]
输出：-1

示例 3：
输入：[2,2,1,1,1,2,2]
输出：2

说明：你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-majority-element-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
===================解法===================
摩尔投票法基于这样一个事实，当一个数的重复次数超过数组长度的一半，每次将两个不相同的数删除，最终剩下的就是要找的数。
class Solution {
    public int majorityElement(int[] nums) {
        int target = -1;
        int cnt = 0;
        for (int i:nums) {
            if (cnt == 0) {
                target = i;
                cnt ++;
            } else {
                if (target == i)
                    cnt ++;
                else
                    cnt --;
            }
        }
        return target;
    }
}
