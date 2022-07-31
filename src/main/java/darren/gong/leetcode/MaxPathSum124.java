package darren.gong.leetcode;

public class MaxPathSum124 {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return maxValue;
        }
        tempMaxPathSum(root);
        return maxValue;
    }

    public int tempMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, tempMaxPathSum(root.left));
        int right = Math.max(0, tempMaxPathSum(root.right));
        maxValue = Math.max(maxValue, left+root.val+right);
        return Math.max(root.val+left, root.val+right);
    }
}
