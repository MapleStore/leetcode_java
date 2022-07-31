package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        addLeft(root.left, result);
        addLeaf(root, result);
        Stack<Integer> stack = new Stack<>();
        addRight(root.right, stack);
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
    private void addLeft(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
            return;
        }
        result.add(treeNode.val);
        if (treeNode.left != null) {
            addLeft(treeNode.left, result);
        } else if (treeNode.right != null) {
            addLeft(treeNode.right, result);
        }
        return;
    }
    private void addLeaf(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.left == null && treeNode.right == null) {
            result.add(treeNode.val);
        } else {
            addLeaf(treeNode.left, result);
            addLeaf(treeNode.right, result);
        }
    }
    private void addRight(TreeNode treeNode, Stack<Integer> result) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) {
            return;
        }
        result.push(treeNode.val);
        if (treeNode.right != null) {
            addRight(treeNode.right, result);
        } else if (treeNode.left != null) {
            addRight(treeNode.left, result);
        }
    }
}
