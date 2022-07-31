package darren.gong.leetcode;

public class RecoverTree99 {
    public void recoverTree(TreeNode root) {
        TreeNode misOne = null;
        TreeNode misTwo = null;
        TreeNode predecessor = null;
        TreeNode pred = null;
        while (root != null) {
            if (root.left == null) {
                if (pred != null && pred.val > root.val) {
                    // 第一个 长的是错误的 predecessor
                    // 第二个 短的是错误的 root
                    misTwo = root;
                    if (misOne == null) {
                        misOne = pred;
                    }
                }
                pred = root;
                root = root.right;
            } else {
                predecessor = getPredecessor(root);
                if (predecessor.right == root) {
                    predecessor.right = null;

                    if (pred != null && pred.val > root.val) {
                        // 第一个 长的是错误的 predecessor
                        // 第二个 短的是错误的 root
                        misTwo = root;
                        if (misOne == null) {
                            misOne = pred;
                        }
                    }
                    pred = root;
                    root = root.right;
                } else {
                    predecessor.right = root;
                    root = root.left;
                }
            }
        }
        int temp = misOne.val;
        misOne.val = misTwo.val;
        misTwo.val = temp;
        return;
    }
    private TreeNode getPredecessor(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode predecessor = treeNode.left;
        while (predecessor.right != null && predecessor.right != treeNode) {
            predecessor = predecessor.right;
        }
        return predecessor;
    }
}
