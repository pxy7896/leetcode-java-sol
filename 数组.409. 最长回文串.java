给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
注意:假设字符串的长度不会超过 1010。

示例 1: 
输入:
"abccccdd"
输出:
7
解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
====================解法====================
'A'的ascii码是65，'a'是97，所以要装完所有字母需要int[58]
要构造最长回文串，计数为偶数的次数可以直接加，计数为奇数的要-1再加，这个可以用
整数的/2*2来统一处理。最后，如果计数总长度小于原字符串长度，说明还有一个单独的字符可以
加上，所以再加1

class Solution {
    public int longestPalindrome(String s) {
        int[] ch = new int[58];
        for (char c : s.toCharArray())
            ch[c-'A'] ++;
        int cnt = 0;
        for (int i : ch)
            cnt += (i/2) * 2;
        if (cnt < s.length())
            cnt ++;
        return cnt;
    }
}
