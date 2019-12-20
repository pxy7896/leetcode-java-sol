给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
示例：
输入: ["Hello", "Alaska", "Dad", "Peace"]
输出: ["Alaska", "Dad"]

注意：
	你可以重复使用键盘上同一字符。
	你可以假设输入的字符串将只包含字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/keyboard-row
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
=============================解法===============================
首先判断单词属于哪一行(使用单词首字母)，然后再判断这个单词有没有不属于同一行的字母。
注意：List<String>转String[]，用toArray(new String[result.size()])

class Solution {
	public String[] findWords(String[] words) {
        List<String> result = new ArrayList<String>();
        for (String s:words) {
        	if (checkSingleWord(s.toLowerCase()))
        		result.add(s);
        }
        return result.toArray(new String[result.size()]);
    }
	boolean checkSingleWord(String word) {
		String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
		String line = null;
		for (String tmp: lines) {
			if (tmp.indexOf(word.charAt(0)) != -1) {
				line = tmp;
				break;
			}
		}
		if (line == null) return false;
		for (int i = 0; i < word.length(); i++) {
			if (line.indexOf(word.charAt(i)) == -1)
				return false;
		}
		return true;
	}
}
