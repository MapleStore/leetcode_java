package darren.gong.leetcode;

import java.util.Stack;

public class BSTIterator173 {
    private Stack<TreeNode> stack = new Stack<>();
    private void addLeftAll(TreeNode node) {
        if (node == null) {
            return;
        }
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }
    public BSTIterator173 (TreeNode root) {
        addLeftAll(root);
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        addLeftAll(node.right);
        return node.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.isEmpty();
    }
}
