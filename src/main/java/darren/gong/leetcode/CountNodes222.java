package darren.gong.leetcode;

public class CountNodes222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countHigh(root.left);
        int right = countHigh(root.right);
        if (left == right) {
            return countNodes(root.right)+(1<<left);// (1<<left)-1  +1(node root)
        } else {
            return countNodes(root.left)+(1<<right);
        }
    }
    private int countHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int high = 1;
        while (root.left != null) {
            high++;
            root = root.left;
        }
        return high;
    }
}
