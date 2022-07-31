package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
                if (size == 0) {
                    result.add(current.val);
                }
            }
        }
        return result;
    }
}
