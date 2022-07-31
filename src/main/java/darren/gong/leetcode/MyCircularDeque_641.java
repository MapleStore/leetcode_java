package darren.gong.leetcode;

public class MyCircularDeque_641 {
  static class Node {
    Node pre;
    Node next;
    int val;
    Node(int value) {
      this.val = value;
    }
  }
  private int size;
  private int limit;
  private Node head;
  private Node tail;
  public MyCircularDeque_641(int k) {
    this.limit = k;
    this.size = 0;
    this.head = new Node(-1);
    this.tail = new Node(-1);
    head.next = tail;
    tail.pre = head;
  }

  public boolean insertFront(int value) {
    if (size >= limit) {
      return false;
    }
    size++;
    Node insert = new Node(value);
    insert.next = head.next;
    insert.pre = head;
    insert.pre.next = insert;
    insert.next.pre = insert;
    return true;
  }

  public boolean insertLast(int value) {
    if (size >= limit) {
      return false;
    }
    size++;
    Node insert = new Node(value);
    insert.next = tail;
    insert.pre = tail.pre;
    insert.pre.next = insert;
    insert.next.pre = insert;
    return true;
  }

  public boolean deleteFront() {
    if (size <= 0) {
      return false;
    }
    size--;
    Node delete = head.next;
    delete.next.pre = delete.pre;
    delete.pre.next = delete.next;
    return true;
  }

  public boolean deleteLast() {
    if (size <= 0) {
      return false;
    }
    size--;
    Node delete = tail.pre;
    delete.next.pre = delete.pre;
    delete.pre.next = delete.next;
    return true;
  }

  public int getFront() {
    if (size <= 0) {
      return -1;
    }
    return head.next.val;
  }

  public int getRear() {
    if (size <= 0) {
      return -1;
    }
    return tail.pre.val;
  }

  public boolean isEmpty() {
    return size <= 0;
  }

  public boolean isFull() {
    return size >= limit;
  }
}
