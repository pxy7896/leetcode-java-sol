编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
示例：
输入： a = 1, b = 2
输出： 2
你考虑过如何处理a – b中的整数溢出吗？
==================解法=======================
1. p > q :
(p+q+p-q)/2 = p
2. p < q :
(p+q+q-p)/2 = q
另外用long处理int可能溢出的case

class Solution {
    public int maximum(int a, int b) {
        long p = a;
        long q = b;
        return (int)((p + q + Math.abs(p-q)) / 2);
    }
}
