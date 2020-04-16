给出一个区间的集合，请合并所有重叠的区间。

示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=================解法===================
先按照区间左端点升序排序，然后设结果集合为ans。遍历排序后的区间集合，对每个interval，
1.如果ans是空的，或者ans[-1][1] < interval[0]，说明两个区间没有overlap，则直接把区间加进去；
2.否则ans[-1][1] = max(ans[-1][1], interval[1])

class Solution {
    public int[][] merge(int[][] intervals) {
        quicksort(intervals, 0, intervals.length-1);
        List<List<Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            // tmp最新一个区间与当前区间不重叠
            if (tmp.isEmpty() || intervals[i][0] > tmp.get(tmp.size()-1).get(1)) {
                List<Integer> num = new ArrayList<>();
                num.add(intervals[i][0]);
                num.add(intervals[i][1]);
                tmp.add(num);
            } else {
                List<Integer> end = tmp.get(tmp.size()-1);
                int maxVal = Math.max(intervals[i][1], end.get(1));
                end.set(1, maxVal);
                tmp.set(tmp.size()-1, end);
            }
        }
        int[][] ans = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            ans[i][0] = tmp.get(i).get(0);
            ans[i][1] = tmp.get(i).get(1);
        }
        return ans;
    }
    void quicksort(int[][] ints, int start, int end) {
        int i, j;
        int[] temp = new int[2];
        if (start > end)
            return;
        assign(temp, ints[start]);
        i = start;
        j = end;
        while (i != j) {
            while (i < j && ints[j][0] >= temp[0])
                j --;
            while (i < j && ints[i][0] <= temp[0])
                i ++;
            if (i < j) {
                int[] tmp = new int[2];
                assign(tmp, ints[i]);
                assign(ints[i], ints[j]);
                assign(ints[j], tmp);
            }
        }
        assign(ints[start], ints[i]);
        assign(ints[i], temp);
        quicksort(ints, start, i-1);
        quicksort(ints, i+1, end); 
    }
    void assign(int[] a, int[] b) {
		  for (int i = 0; i < a.length; i++) {
			  a[i] = b[i];
		  }
	  }
}
