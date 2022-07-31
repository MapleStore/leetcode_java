package darren.gong.leetcode.offer;

import java.util.Stack;

public class VerifyPostorder_33 {
  // 剑指 Offer 33. 二叉搜索树的后序遍历序列
  public static void main(String[] args) {
    VerifyPostorder_33 verifyPostorder_33 = new VerifyPostorder_33();
    verifyPostorder_33.verifyPostorder(new int[]{1,3,2,6,5});
  }
  public boolean verifyPostorder(int[] postorder) {
    return verifyPostorder(postorder, 0, postorder.length-1);
  }
  private boolean verifyPostorder(int[] postorder, int left, int right) {
    if (left >= right) {
      return true;
    }
    int currentValue = postorder[right];
    int rightIndex = left;
    for (; rightIndex < right; rightIndex++) {
      if (postorder[rightIndex] > currentValue) {
        break;
      }
    }
    for (int i = rightIndex; i < right; i++) {
      if (postorder[i] < currentValue) {
        return false;
      }
    }
    return verifyPostorder(postorder, left, rightIndex-1) && verifyPostorder(postorder, rightIndex, right-1);
  }
}
