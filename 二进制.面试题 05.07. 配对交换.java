配对交换。编写程序，交换某个整数的奇数位和偶数位，尽量使用较少的指令（也就是说，位0与位1交换，位2与位3交换，以此类推）。

示例1:
输入：num = 2（或者0b10）
输出 1 (或者 0b01)

示例2:
输入：num = 3
输出：3

提示: num的范围在[0, 2^30 - 1]之间，不会发生整数溢出。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/exchange-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==============解法==================
class Solution {
    public int exchangeBits(int num) {
        int oddBitMask = 0xaaaaaaaa;
		    // System.out.println("int: " + String.valueOf(oddBitMask) + " bin: " + Integer.toBinaryString(oddBitMask));
        // int: -1431655766 bin: 10101010101010101010101010101010
        int evenBitMask = 0x55555555;
        // System.out.println("int: " + String.valueOf(evenBitMask) + " bin: " + Integer.toBinaryString(evenBitMask));
        // int: 1431655765 bin: 1010101010101010101010101010101
        int oddBit = (num & oddBitMask) >> 1;
        int evenBit = (num & evenBitMask) << 1;
        return oddBit ^ evenBit;
    }
}
