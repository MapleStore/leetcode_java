package darren.gong.leetcode;

public class Flatten430 {
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        flattenHelper(head);
        return head;
    }
    public Node flattenHelper(Node head) {
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (current.child != null) {
                Node preNext = flattenHelper(current.child);
                preNext.next = next;
                if (next != null) {
                    next.prev = preNext;
                }

                current.next = current.child;
                current.child.prev = current;
                current.child = null;

                current = preNext;
            }
            if (next == null) {
                break;
            }
            current = next;
        }
        return current;
    }

}
