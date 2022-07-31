package darren.gong.leetcode;


import java.util.HashMap;
import java.util.Map;

public class LargestBSTSubtree333 {
    // [10,5,15,1,8,null,7]
    Map<TreeNode, Boolean> isBST = new HashMap<>();
    Map<TreeNode, Integer> maxNode = new HashMap<>();
    Map<TreeNode, Integer> minNode = new HashMap<>();
    Map<TreeNode, Integer> nodeNum = new HashMap<>();
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (maxNode(root.left) < root.val && root.val < minNode(root.right) && isBST(root.left) && isBST(root.right)) {
            return countNodes(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isBST.containsKey(root)) {
            return isBST.get(root);
        }
        if (maxNode(root.left) < root.val && root.val < minNode(root.right) && isBST(root.left) && isBST(root.right)) {
            isBST.put(root, true);
            return true;
        }
        isBST.put(root, false);
        return false;
    }
    private int maxNode(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (maxNode.containsKey(root)) {
            return maxNode.get(root);
        }
        int result = Math.max(maxNode(root.left), Math.max(maxNode(root.right), root.val));
        maxNode.put(root, result);
        return result;
    }
    private int minNode(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (minNode.containsKey(root)) {
            return minNode.get(root);
        }
        int result = Math.min(minNode(root.left), Math.min(minNode(root.right), root.val));
        minNode.put(root, result);
        return result;
    }
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (nodeNum.containsKey(root)) {
            return nodeNum.get(root);
        }
        int result = countNodes(root.left)+countNodes(root.right)+1;
        nodeNum.put(root, result);
        return result;
    }
}
