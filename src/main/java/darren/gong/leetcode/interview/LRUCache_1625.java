package darren.gong.leetcode.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_1625 {
  // 面试题 16.25. LRU 缓存
  public static void main(String[] args) {
    LRUCache_1625 lruCache_1625 = new LRUCache_1625(2);
    lruCache_1625.put(1,1);
    lruCache_1625.put(2,2);
    lruCache_1625.get(2);
    lruCache_1625.put(2,2);
    lruCache_1625.put(3,3);
    lruCache_1625.get(2);
  }
  private class Node {
    private int value;
    private int key;
    private Node pre;
    private Node next;
    public Node(int value) {
      this.value = value;
    }
    public Node() {
    }
  }
  private int capacity;
  private Map<Integer, Node> map;
  private Node head;
  private Node tail;
  public LRUCache_1625(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>(capacity);
    head = new Node(-1);
    tail = new Node(-1);
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    if (capacity <= 0) {
      return -1;
    }
    Node result = deleteNode(key);
    if (result == null) {
      return -1;
    }
    addToEnd(result);
    return result.value;
  }

  public void put(int key, int value) {
    if (capacity <= 0) {
      return;
    }
    Node result = deleteNode(key);
    if (result == null) {
      result = new Node();
    }
    result.key = key;
    result.value = value;
    addToEnd(result);

    if (map.size() > capacity) {
      deleteHead();
    }
  }

  private Node deleteNode(int key) {
    Node result = map.remove(key);
    if (result == null) {
      return null;
    }

    result.pre.next = result.next;
    result.next.pre = result.pre;
    return result;
  }
  private void addToEnd(Node node) {
    map.put(node.key, node);
    node.pre = tail.pre;
    node.pre.next = node;
    node.next = tail;
    tail.pre = node;
  }
  private void deleteHead() {
    int key = head.next.key;
    deleteNode(key);
  }
}
