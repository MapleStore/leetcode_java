package darren.gong.leetcode;

public class VerifyPreorder_255 {
  // 255. 验证前序遍历序列二叉搜索树
  public boolean verifyPreorder(int[] preorder) {
    return verifyPreorder(preorder, 0, preorder.length-1);
  }
  public boolean verifyPreorder(int[] preorder, int left, int right) {
    if (left >= right) {
      return true;
    }
    int current = preorder[left];
    int i = left+1;
    for (; i <= right; i++) {
      if (preorder[i] > current) {
        break;
      }
    }
    for (int j = i+1; j <= right; j++) {
      if (preorder[j] < current) {
        return false;
      }
    }
    return verifyPreorder(preorder, left+1, i-1) && verifyPreorder(preorder, i, right);
  }
  public boolean verifyPreorder2(int[] postorder) {
    int stackIndex = -1;
    int length = postorder.length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < length; i++) {
      if (postorder[i] < max) {
        return false;
      }
      while (stackIndex != -1 && postorder[stackIndex] < postorder[i]) {
        max = Math.max(max, postorder[stackIndex--]);
      }
      postorder[++stackIndex] = postorder[i];
    }
    return true;
  }
}
