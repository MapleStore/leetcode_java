package darren.gong.leetcode;

public class IsValidBST98 {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        } else {
            pre = root.val;
        }
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
