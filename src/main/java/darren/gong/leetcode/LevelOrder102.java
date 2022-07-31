package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> oneLine = new LinkedList<Integer>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                oneLine.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            result.add(oneLine);
        }
        return result;
    }
}
