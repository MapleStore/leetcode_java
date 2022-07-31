package darren.gong.leetcode;

public class MyLinkedList707 {
    public static void main(String[] args) {
        MyLinkedList707 linkedList = new MyLinkedList707();
        /*
                ["addAtHead",[0]
                "addAtIndex",[1,4]
                "addAtTail",[8]
                "addAtHead",[5]
                "addAtIndex",[4,3]
                "addAtTail",[0]
                "addAtTail",[5]
                "addAtIndex",[6,3]
                "deleteAtIndex",[7]
                "deleteAtIndex",[5]
                "addAtTail" [4]
                ]
                [[1,4],[8],[5],[4,3],[0],[5],[6,3],[7],[5],[4]]
        */
        linkedList.addAtHead(0);// 0
        linkedList.addAtIndex(1,4);// 0 4
        linkedList.addAtTail(8);// 0 4 8
        linkedList.addAtHead(5);// 5 0 4 8
        linkedList.addAtIndex(4,3);// 5 0 4 8 3
        linkedList.addAtTail(0);// 5 0 4 8 3 0
        linkedList.addAtTail(5);// 5 0 4 8 0 3 5
        linkedList.addAtIndex(6,3);// 6 1 2 0 4
        linkedList.deleteAtIndex(7);// 6 1 2 0 4
        linkedList.deleteAtIndex(5);// 6 1 2 0 4
        linkedList.addAtTail(4);
    }
    private int size = 0;
    private Node head;
    private Node tail;
    private class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    /** Initialize your data structure here. */
    public MyLinkedList707() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node current = head;
        while (index-- > 0) {
            current = current.next;
        }
        return current.value;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
        return;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        Node newNode = new Node(val);
        if (size == 0) {
            head = newNode;
            tail = head;
        } else {
            if (index == size) {
                addAtTail(val);
                return;
            } else if (index <= 0) {
                addAtHead(val);
                return;
            } else {
                Node current = head;
                while (index-- > 1) {
                    current = current.next;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
        }
        size++;
        return;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            while (index-- > 1) {
                current = current.next;
            }
            if (current.next == tail) {
                tail = current;
            }
            current.next = current.next.next;
        }
        size--;
        return;
    }
}
