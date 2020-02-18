二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
每个 LED 代表一个 0 或 1，最低位在右侧。
顶部四个灯分别代表 8 4 2 1
底部四个灯分别代表 32 16 8 4 2 1
给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。

案例:
输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

注意事项:
	输出的顺序没有要求。
	小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
	分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-watch
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==========================解法===========================
按12x60循环，如果时和分的数字，其中含有的1的个数之和，为num，则添加这个时刻。
计算某数字转二进制后1的个数，可以用n&(n-1)，循环
class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> ans = new ArrayList<String>();
    	if (num == 0) {
    		ans.add("0:00");
    		return ans;
    	}
    	for (int i = 0; i < 12; i++) {
    		for (int j = 0; j < 60; j++) {
    			if (cnt1(i)+cnt1(j) == num) {
    				ans.add(i + ":" + (j<10?"0"+j:j));
    			}
    		}
    	}
    	return ans;
    }
    int cnt1(int num) {
    	int cnt = 0;
    	while (num != 0) {
    		num = num & (num-1);
    		cnt ++;
    	}
    	return cnt;
    }
}
