package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class MinimumAbsoluteDifferenceinBST {
    List<Integer> result = new LinkedList<>();
    int maxTimes = 0;
    int currentTimes = 0;
    int pre = -1;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] intResult = new int[result.size()];
        int index = 0;
        for (int oneResult : result) {
            intResult[index++] = oneResult;
        }
        return intResult;
    }
    public void dfs(TreeNode current) {
        if (current == null) {
            return;
        }
        dfs(current.left);
        if (current.val == pre) {
            currentTimes++;
        } else {
            currentTimes = 1;
            pre = current.val;
        }
        if (currentTimes > maxTimes) {
            result = new LinkedList<>();
            maxTimes = currentTimes;
            result.add(current.val);
        } else if (currentTimes == maxTimes) {
            result.add(current.val);
        }
        dfs(current.right);
        return;
    }
}
