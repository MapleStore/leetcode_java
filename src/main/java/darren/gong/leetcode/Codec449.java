package darren.gong.leetcode;

public class Codec449 {
    private void postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(',');
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private TreeNode deserialize(String[] arr, int low, int high, TreeNode index) {
        if (index.val < 0) {
            return null;
        }
        int current = Integer.valueOf(arr[index.val]);
        if (current > high || current < low) {
            return null;
        }
        TreeNode currentNode = new TreeNode(current);
        index.val--;
        currentNode.right = deserialize(arr, current, high, index);
        currentNode.left = deserialize(arr, low, current, index);
        return currentNode;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] stringData = data.split(",");
        return deserialize(stringData, Integer.MIN_VALUE, Integer.MAX_VALUE, new TreeNode(stringData.length-1));
    }
}
