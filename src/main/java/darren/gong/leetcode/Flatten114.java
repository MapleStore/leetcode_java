package darren.gong.leetcode;

public class Flatten114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left != null) {
                TreeNode predecessor = getPredecessor(root);
                predecessor.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    private TreeNode getPredecessor(TreeNode treeNode) {
        TreeNode predecessor = treeNode.left;
        while (predecessor.right != null) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }
}
