给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回其自底向上的层次遍历为：
[
  [15,7],
  [9,20],
  [3]
]
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
======================解法========================
如果不用Collections.reverse的话就是完全的层次遍历。按层遍历使用递归。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> li = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        bfs(root, 0);
        Collections.reverse(li);
        return li;
    }
    private void bfs(TreeNode root, int level) {
        if (root == null) 
            return;
        if (li.size() <= level) // 层数已经加1了，添加一个list
            li.add(new ArrayList<Integer>());
        bfs(root.left, level+1);
        bfs(root.right, level+1);
        li.get(level).add(root.val); // level就是层高了
    }
}
