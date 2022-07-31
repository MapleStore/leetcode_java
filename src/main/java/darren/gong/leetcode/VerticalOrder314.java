package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrder314 {
    private class Entry {
        TreeNode node;
        int index;
        public Entry(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        Queue<Entry> queue = new LinkedList<>();
        Map<Integer, List<Integer>> result = new TreeMap<>();
        queue.add(new Entry(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Entry current = queue.poll();
                if (!result.containsKey(current.index)) {
                    result.put(current.index, new LinkedList<>());
                }
                result.get(current.index).add(current.node.val);
                if (current.node.left != null) {
                    queue.add(new Entry(current.node.left, current.index-1));
                }
                if (current.node.right != null) {
                    queue.add(new Entry(current.node.right, current.index+1));
                }
            }
        }
        return new LinkedList<>(result.values());
    }
}
