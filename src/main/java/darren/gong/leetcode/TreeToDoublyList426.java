package darren.gong.leetcode;

public class TreeToDoublyList426 {
    public static void main(String[] args) {
        TreeToDoublyList426 treeToDoublyList426 = new TreeToDoublyList426();
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        treeToDoublyList426.treeToDoublyList(root);
    }
    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    private Node pre;
    private Node head;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    private void dfs(Node current) {
        if (current == null) {
            return;
        }
        dfs(current.left);

        if (head == null) {
            head = current;
        }
        current.left = pre;
        if (pre != null) {
            pre.right = current;
        }
        pre = current;

        dfs(current.right);
    }
}
