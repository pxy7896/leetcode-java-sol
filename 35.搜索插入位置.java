给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

示例 1:
输入: [1,3,5,6], 5
输出: 2

示例 2:
输入: [1,3,5,6], 2
输出: 1

示例 3:
输入: [1,3,5,6], 7
输出: 4

示例 4:
输入: [1,3,5,6], 0
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/search-insert-position
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==========================解法======================================================
二分查找
package hello;

public class Test {
	public int searchInsert(int[] nums, int target) {
		int low = 0;
        int high = nums.length - 1;
        if (target < nums[0]) return 0;
        if (target > nums[high]) return high + 1;
        int mid;
        while (low < high) {
        	mid = (low + high) / 2;
        	if (nums[mid] < target) {
        		low = mid + 1; // 这里记住是+1!!!!
        	} else if (nums[mid] == target) {
        		return mid;
        	}
        	else {
        		high = mid;
        	}
        }
        return high;
    }
		  
	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 5;
		System.out.println(new Test().searchInsert(nums, target));
		//System.out.println(new Test().romanToInt("LVIII"));
	}
}
