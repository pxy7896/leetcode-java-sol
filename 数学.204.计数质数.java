统计所有小于非负整数 n 的质数的数量。

示例:
输入: 10
输出: 4
解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-primes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=====================解法==================
这里的巧妙之处在于缩短判断时间。对于一个小于n的整数m，原本只要判断到sqrt(m)即可知道m是不是质数了，
但是如果要找n范围内所有的，其实可以从因子角度来化简。即使p是质数，p^2,p^2+p,p^3+p...也都不是质数，
因此可以用boolean数组记录是否是质数。
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i*i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime[i])
                cnt++;
        }
        return cnt;
    }
}
