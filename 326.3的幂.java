给定一个整数，写一个函数来判断它是否是 3 的幂次方。
=====================解法==========================
Integer.toString()可以指定进制，是3的幂次方表示它应该以1开头，后面有>=0个'0'，且不含其他字符。
用正则表达式最好。
class Solution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
}
刷342.4的幂是一样的。但是速度慢。需要再处理一下。
