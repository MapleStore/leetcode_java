package darren.gong.leetcode;

public class MyCircularQueue622 {
    private class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    int size;
    int count;
    Node head;
    Node tail;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue622(int k) {
        this.size = k;
        count = 0;
        head = new Node(-1);
        tail = head;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (count == size) {
            return false;
        }
        tail.next = new Node(value);
        tail = tail.next;
        count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        head = head.next;
        count--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (count == 0) {
            return -1;
        }
        return head.next.val;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (count == 0) {
            return -1;
        }
        return tail.val;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == size;
    }
}
