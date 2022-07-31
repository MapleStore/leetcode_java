package darren.gong.leetcode;

public class ClosestValue270 {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return -1;
        }
        int result = root.val;
        while (root != null) {
            int value = root.val;
            result = Math.abs(target-result) > Math.abs(target-value) ? value : result;
            root = target > value ? root.right : root.left;
        }
        return result;
    }
}
