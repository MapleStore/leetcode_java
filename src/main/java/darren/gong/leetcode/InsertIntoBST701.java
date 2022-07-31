package darren.gong.leetcode;

public class InsertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode current = root;
        while (current != null) {
            if (val > current.val) {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    return root;
                } else {
                    current = current.right;
                }
            } else {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    return root;
                } else {
                    current = current.left;
                }
            }
        }
        return null;
    }
}
