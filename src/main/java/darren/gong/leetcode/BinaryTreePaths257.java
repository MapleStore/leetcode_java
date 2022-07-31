package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        List<String> result = new ArrayList<String>(8);
        backTracking(root, new ArrayList<Integer>(8), result);
        return result;
    }
    public void backTracking(TreeNode node, List<Integer> oneResult, List<String> result) {
        oneResult.add(node.val);
        if (node.right == null && node.left == null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < oneResult.size(); i++) {
                str.append(oneResult.get(i));
                if (i != oneResult.size() - 1) {
                    str.append("->");
                }
            }
            result.add(str.toString());
        } else {
            if (node.left != null) {
                backTracking(node.left, oneResult, result);
            }
            if (node.right != null) {
                backTracking(node.right, oneResult, result);
            }
        }
        oneResult.remove(oneResult.size()-1);
        return;
    }
}
