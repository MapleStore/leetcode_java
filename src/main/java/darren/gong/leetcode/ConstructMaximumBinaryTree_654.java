package darren.gong.leetcode;

public class ConstructMaximumBinaryTree_654 {
  // 654. 最大二叉树
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructMaximumBinaryTree(nums, 0, nums.length-1);
  }
  public TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return new TreeNode(nums[left]);
    }
    int index = left;
    for (int i = left; i <= right; i++) {
      if (nums[i] > nums[index]) {
        index = i;
      }
    }
    TreeNode node = new TreeNode(nums[index]);
    node.left = constructMaximumBinaryTree(nums, left, index-1);
    node.right = constructMaximumBinaryTree(nums, index+1, right);
    return node;
  }
}
