package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigzagLevelOrder103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean rightFirst = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneResult = new LinkedList<Integer>();
            Stack<Integer> newStack = new Stack<Integer>();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                if (rightFirst) {
                    newStack.push(current.val);
                } else {
                    oneResult.add(current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            while (newStack.size() > 0) {
                oneResult.add(newStack.pop());
            }
            result.add(oneResult);
            rightFirst = !rightFirst;
        }
        return result;
    }
}
