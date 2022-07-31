package darren.gong.leetcode;

import java.util.HashMap;

public class BuildTree106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        if (postorder == null || postorder.length == 0) {
            return new TreeNode(-1);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return build(hashMap, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    public TreeNode build(HashMap<Integer, Integer> hashMap, int[] postOrder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int rootValue = postOrder[postEnd];
        int rootInIndex = hashMap.get(rootValue);
        TreeNode rootNode = new TreeNode(rootValue);
        rootNode.left = build(hashMap, postOrder, inStart, rootInIndex-1, postStart, postStart+(rootInIndex-1-inStart));
        rootNode.right = build(hashMap, postOrder, rootInIndex+1, inEnd, postStart+(rootInIndex-inStart), postEnd-1);
        return rootNode;
    }
}
