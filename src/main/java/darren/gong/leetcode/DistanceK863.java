package darren.gong.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class DistanceK863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null) {
            return new LinkedList<>();
        }
        Map<TreeNode, TreeNode> map = new HashMap();
        dfs(root, map);
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        int distance = 0;
        queue.add(target);
        visited.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode treeNode = queue.poll();
                if (distance == K) {
                    result.add(treeNode.val);
                } else {
                    if (treeNode.left != null && !visited.contains(treeNode.left)) {
                        queue.add(treeNode.left);
                        visited.add(treeNode.left);
                    }
                    if (treeNode.right != null && !visited.contains(treeNode.right)) {
                        queue.add(treeNode.right);
                        visited.add(treeNode.right);
                    }
                    TreeNode parent = map.get(treeNode);
                    if (parent != null && !visited.contains(parent)) {
                        queue.add(parent);
                        visited.add(parent);
                    }
                }
            }
            distance++;
        }
        return result;
    }
    private void dfs(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
        }
        if (root.right != null) {
            map.put(root.right, root);
        }
        dfs(root.left, map);
        dfs(root.right, map);
    }
}
