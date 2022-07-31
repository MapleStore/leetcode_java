package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();

        Node current = head;
        Node newHead = new Node(head.val);
        Node newCurrent = newHead;
        map.put(head, newHead);
        while (current.next != null) {
            Node newNext = new Node(current.next.val);
            newCurrent.next = newNext;
            map.put(current.next, newNext);
            current = current.next;
            newCurrent = newCurrent.next;
        }

        current = head;
        newCurrent = newHead;
        while (current != null) {
            if (current.random == null) {
                newCurrent.random = null;
            } else {
                newCurrent.random = map.get(current.random);
            }
            current = current.next;
            newCurrent = newCurrent.next;
        }
        return newHead;
    }
}
