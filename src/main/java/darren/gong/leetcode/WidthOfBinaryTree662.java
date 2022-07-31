package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree662 {
    private class Entry {
        private TreeNode treeNode;
        private int index;
        public Entry(TreeNode treeNode, int index) {
            this.treeNode = treeNode;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(root, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = Integer.MIN_VALUE;
            int end = Integer.MIN_VALUE;
            while (size-- > 0) {
                Entry entry = queue.poll();
                if (start == Integer.MIN_VALUE) {
                    start = entry.index;
                }
                end = entry.index;
                if (entry.treeNode.left != null) {
                    queue.add(new Entry(entry.treeNode.left, entry.index*2));
                }
                if (entry.treeNode.right != null) {
                    queue.add(new Entry(entry.treeNode.right, entry.index*2+1));
                }
            }
            result = Math.max(result, end-start+1);
        }
        return result;
    }
}
