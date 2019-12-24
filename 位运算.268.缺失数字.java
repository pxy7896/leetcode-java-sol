给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。

示例 1:
输入: [3,0,1]
输出: 2

示例 2:
输入: [9,6,4,2,3,5,7,0,1]
输出: 8

说明:
你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/missing-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==============================解法=================================
第一种方法是求和，用高斯定理计算0~n的和然后减去实际的总和，即缺失的数字；
第二种方法是位运算，因为下标是0~(n-1)，初始令miss=nums.length，每次令miss与下标和下标对应的数字做异或，
最终，下标x会与某个数字对应上，由于异或满足交换律和结合律，所以能对应上的就会变成0，对应不上的就是缺失的那个数字。
如[3, 0, 1]对应下标[0, 1, 2]，那么整个计算公式即 
3 ^ 3 ^ 0 ^ 0 ^ 1 ^ 1 ^ 2 = 0 ^ 0 ^ 0 ^ 2 = 2

class Solution {
    /*public int missingNumber(int[] nums) {
        int sum = 0;
        for (int i: nums) sum += i;
        return (nums.length*(nums.length+1))/2 - sum;
    }*/
    public int missingNumber(int[] nums) {
        int miss = nums.length;
        for (int i = 0; i < nums.length; i++) {
            miss ^= i ^ nums[i];
        }
        return miss;
    }
}
