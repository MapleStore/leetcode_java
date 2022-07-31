package darren.gong.leetcode;

public class LongestConsecutive_298 {
    private int result = 1;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root.val, 0);
        return result;
    }
    private void dfs(TreeNode node, int value, int length) {
        if (node == null) {
            return;
        }
        if (node.val == value) {
            result = Math.max(result, length+1);
            dfs(node.left, value+1, length+1);
            dfs(node.right, value+1, length+1);
            return;
        }
        dfs(node.left, node.val+1, 1);
        dfs(node.right, node.val+1, 1);
    }
}
