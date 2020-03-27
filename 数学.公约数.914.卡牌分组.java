给定一副牌，每张牌上都写着一个整数。
此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
每组都有 X 张牌。组内所有的牌上都写着相同的整数。
仅当你可选的 X >= 2 时返回 true。

示例 1：
输入：[1,2,3,4,4,3,2,1]
输出：true
解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]

示例 2：
输入：[1,1,1,2,2,2,3,3]
输出：false
解释：没有满足要求的分组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==============解法==================
先统计各个数字的频数，然后求频数们的最大公约数

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for (int i:deck) {
            if (m.containsKey(i)) {
                int val = m.get(i) + 1;
                m.replace(i, val);

            } else {
                m.put(i, 1);
            }
        }
        int g = -1;
        for(Map.Entry<Integer,Integer> e:m.entrySet()) {
            int val = e.getValue();
            if (g == -1) {
                g = val;
            } else {
                g = gcd(g, val);
            }
        }
        return g > 1;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a%b);
    }
}
