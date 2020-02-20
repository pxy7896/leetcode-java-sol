给出一个按 非递减 顺序排列的数组 nums，和一个目标数值 target。假如数组 nums 中绝大多数元素的数值都等于 target，则返回 True，否则请返回 False。

所谓占绝大多数，是指在长度为 N 的数组中出现必须 超过 N/2 次。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=================解法===========================
既然是非递减顺序排列好了，那么如果一个数要出现超过N/2次，那么数组中间那个值必须是这个数字。
因此只判断中间那个数字即可。
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int mid = (nums.length - 1) / 2;
        if (nums[mid] == target)
            return true;
        else
            return false;
    }
}
