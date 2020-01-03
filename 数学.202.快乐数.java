编写一个算法来判断一个数是不是“快乐数”。
一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到
这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。

示例: 
输入: 19
输出: true
解释: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/happy-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=======================解法=====================================
如果不是快乐数，一定会陷入循环：
4 16 37 72 53 40 16...
所以只要计算一下，有没有落入到为4的情况即可：
class Solution {
    public boolean isHappy(int n) {
        boolean flag = false;
        int num = n; // 这里要记住n，为了后面继续迭代
        while (true) {
            int sum = 0;
            while(num != 0) {
                sum += (num%10)*(num%10);
                num /= 10;
            }
            if (sum == 1) {
                flag = true;
                break;
            }
            if (sum == 4) {
                flag = false;
                break;
            }
            num = sum;
        }
        return flag;
    }
}
