package darren.gong.leetcode;

public class InorderSuccessor285 {
    TreeNode pre = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return root;
        }
        TreeNode result = inorderSuccessor(root.left, p);
        if (result != null) {
            return result;
        }
        if (pre == p) {
            return root;
        }
        pre = root;
        result = inorderSuccessor(root.right, p);
        return result;
    }
}
