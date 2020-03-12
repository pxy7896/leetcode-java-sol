给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/permutations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
============解法=====================
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return ans;
        else {
            helper(nums, new Stack<Integer>());
            return ans;
        }
    }
    private void helper(int[] nums, Stack<Integer> s) {
        if (s.size() == nums.length) {
            ans.add(new ArrayList<Integer>(s));
            return;
        } 
        for (int n:nums) {
            if (s.contains(n))
                continue;
            s.push(n);
            helper(nums, s);
            s.pop();
        }

    }
}
类似的题目有：77.组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combinations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
==========解法=================
添加一个start来限定
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k > n)
            return ans;
        else {
            int[] nums = new int[n];
            for (int i = 0; i < n; i++)
                nums[i] = i+1;
            helper(nums, new Stack<Integer>(), k, 0);
            return ans;
        }
    }
    private void helper(int[] nums, Stack<Integer> s, int k, int start) {
        if (s.size() == k) {
            ans.add(new ArrayList<Integer>(s));
            return;
        } 
        for (int i = start; i < nums.length; i++) {
            if (s.contains(nums[i]))
                continue;
            s.push(nums[i]);
            helper(nums, s, k, i+1);
            s.pop();
        }

    }
}
