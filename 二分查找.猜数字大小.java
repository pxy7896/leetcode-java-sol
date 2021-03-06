我们正在玩一个猜数字游戏。 游戏规则如下：
我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。每次你猜错了，我会告诉你这个数字是大了还是小了。
你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：

-1 : 我的数字比较小
 1 : 我的数字比较大
 0 : 恭喜！你猜对了！

示例 :
输入: n = 10, pick = 6
输出: 6

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=============================解法==================================
这道题本身使用二分查找简单，但是要注意，用例里有很大的数字，所以要将mid = (low+high) / 2改为
mid = low + (high-low)/2

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int mid = low;
        while (low <= high) {
            //mid = (low + high) / 2;
            mid = low + (high-low)/2; // case: 2126753390
            if (guess(mid) == 0) break;
            else if (guess(mid) == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }
}
