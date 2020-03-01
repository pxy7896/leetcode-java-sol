给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。

示例:
输入:
letters = ["c", "f", "j"]
target = "a"
输出: "c"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=============解法=====================
二分法
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target-'a' >= letters[letters.length-1]-'a')
            return letters[0];
        int low = 0;
        int high = letters.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if (letters[mid]-'a' <= target-'a')
                low = mid + 1;
            else 
                high = mid - 1;        
        }
        return letters[low];
    }
}
