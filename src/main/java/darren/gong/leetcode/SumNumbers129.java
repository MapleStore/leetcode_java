package darren.gong.leetcode;

public class SumNumbers129 {
    private int result = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sumNumbers(root, 0);
        return result;
    }
    private void sumNumbers(TreeNode current, int sum) {
        int currentSum = current.val+sum*10;
        if (current.left == null && current.right == null) {
            result = result+currentSum;
        }
        if (current.left != null) {
            sumNumbers(current.left, currentSum);
        }
        if (current.right != null) {
            sumNumbers(current.right, currentSum);
        }
    }
}
