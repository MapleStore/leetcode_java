package darren.gong.leetcode;

public class MirrorTree {
    public boolean isMirror(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null || treeNode2 == null) {
            if (treeNode1 != null || treeNode2 != null) {
                return false;
            }
            return true;
        }
        if (treeNode1.val != treeNode2.val) {
            return false;
        }
        return isMirror(treeNode1.left, treeNode2.right) && isMirror(treeNode1.right, treeNode2.left);
    }
}
