package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindFrequentTreeSum_508 {
    Map<Integer, Integer> counts = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        dfs(root);
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                count = 1;
            } else if (entry.getValue() == max) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == max) {
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
    private int dfs(TreeNode node) {
        int left = 0;
        if (node.left != null) {
            left = dfs(node.left);
        }
        int right = 0;
        if (node.right != null) {
            right = dfs(node.right);
        }
        int result = node.val+left+right;
        counts.put(result, counts.getOrDefault(result, 0)+1);
        return result;
    }
}
