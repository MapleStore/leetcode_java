package darren.gong.leetcode;

public class Connect117 {
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node preRoot = root;
        Node lastNode = null;
        Node nextRoot = null;
        while (preRoot != null) {
            if (preRoot.left != null) {
                if (lastNode == null) {
                    lastNode = preRoot.left;
                    nextRoot = lastNode;
                } else {
                    lastNode.next = preRoot.left;
                    lastNode = lastNode.next;
                }
            }
            if (preRoot.right != null) {
                if (lastNode == null) {
                    lastNode = preRoot.right;
                    nextRoot = lastNode;
                } else {
                    lastNode.next = preRoot.right;
                    lastNode = lastNode.next;
                }
            }
            if (preRoot.next == null) {
                preRoot = nextRoot;
                lastNode = null;
                nextRoot = null;
            } else {
                preRoot = preRoot.next;
            }
        }
        return root;
    }
}






