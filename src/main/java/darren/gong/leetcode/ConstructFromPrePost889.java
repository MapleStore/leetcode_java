package darren.gong.leetcode;

public class ConstructFromPrePost889 {
  public TreeNode constructFromPrePost(int[] pre, int[] post) {
    return constructFromPrePostHelper(pre, 0, pre.length-1, post, 0, post.length-1);
  }
  public TreeNode constructFromPrePostHelper(int[] pre, int preLeft, int preRight, int[] post, int postLeft, int postRight) {
    if (preLeft > preRight) {
      return null;
    }
    TreeNode node = new TreeNode(pre[preLeft]);
    if (preLeft == preRight) {
      return node;
    }
    int postIndex = postLeft;
    for (; postIndex <= postRight; postIndex++) {
      if (post[postIndex] == pre[preLeft+1]) {
        break;
      }
    }
    int leftNodeNum = postIndex-postLeft+1;
    node.left = constructFromPrePostHelper(pre, preLeft+1, preLeft+leftNodeNum, post, postLeft, postIndex);
    node.right = constructFromPrePostHelper(pre, preLeft+leftNodeNum+1, preRight, post, postIndex+1, postRight-1);
    return node;
  }
}
