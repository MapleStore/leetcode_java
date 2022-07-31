package darren.gong.leetcode;

public class DeleteNode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            findRightLeaf(root.left).right = root.right;
            return root.left;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode findRightLeaf(TreeNode root) {
        if (root.right != null) {
            return findRightLeaf(root.right);
        }
        return root;
    }
}
