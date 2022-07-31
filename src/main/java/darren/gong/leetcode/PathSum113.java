package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        pathSum(root, sum, new LinkedList<>(), result);
        return result;
    }
    private void pathSum(TreeNode current, int sum, List<Integer> oneResult, List<List<Integer>> result) {
        if (current == null) {
            return;
        }
        if (sum == current.val && current.left == null && current.right == null) {
            List<Integer> toBeAdd = new LinkedList<>(oneResult);
            toBeAdd.add(current.val);
            result.add(toBeAdd);
            return;
        }
        oneResult.add(current.val);
        pathSum(current.left, sum-current.val, oneResult, result);
        pathSum(current.right, sum-current.val, oneResult, result);
        oneResult.remove(oneResult.size()-1);
        return;
    }
}
