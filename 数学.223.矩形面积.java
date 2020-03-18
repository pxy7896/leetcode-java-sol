在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
每个矩形由其左下顶点和右上顶点坐标表示，如图所示。

示例:
输入: -3, 0, 3, 4, 0, -1, 9, 2
输出: 45
说明: 假设矩形面积不会超出 int 的范围。
==============解法===========
画一下图。这个前面用到判断两个矩形是否相交。
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = (C - A) * (D - B);
        int a2 = (G - E) * (H - F);
        // 如果不重叠，那么返回和
        if (C <= E || A >= G || D <= F || B >= H)
            return a1 + a2;
        int diff = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        // 防止a1+a2溢出
        return a1 - diff + a2;
    }
}
