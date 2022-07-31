package darren.gong.leetcode;

public class BuildTree105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inIndex = i;
            }
        }
        treeNode.left = buildTree(preorder, preStart+1, preStart+inIndex-inStart, inorder, inStart, inIndex-1);
        treeNode.right = buildTree(preorder, preStart+inIndex-inStart+1, preEnd, inorder, inIndex+1, inEnd);
        return treeNode;
    }
}
