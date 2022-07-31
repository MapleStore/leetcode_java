package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache460 {
  private class Node {
    private int key;
    private int value;
    private int frequent;
    private Node(int key, int value, int frequent) {
      this.key = key;
      this.value = value;
      this.frequent = frequent;
    }
  }
  private int capacity = 0;
  private Map<Integer, Node> keyToNode = new HashMap<>();
  private Map<Integer, Set<Integer>> frequentToKey = new HashMap<>();
  private int minFrequent = 0;
  public LFUCache460(int capacity) {
    this.capacity = capacity;
  }

  public static void main(String[] args) {
    LFUCache460 lfuCache460 = new LFUCache460(2);
    lfuCache460.put(3,1);
    lfuCache460.put(2,1);
    lfuCache460.put(2,2);
    lfuCache460.put(4,4);
    lfuCache460.get(2);
  }
  public int get(int key) {
    if (capacity == 0) {
      return -1;
    }
    Node node = keyToNode.get(key);
    if (node == null) {
      return -1;
    }
    remove(node);
    addNode(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    Node node = keyToNode.get(key);
    if (node == null) {
      if (capacity == keyToNode.size()) {
        Iterator<Integer> iterator = frequentToKey.get(minFrequent).iterator();
        int keyToBeDelete = iterator.next();
        iterator.remove();
        keyToNode.remove(keyToBeDelete);
      }
      Node newNode = new Node(key, value, 1);
      addNode(newNode);
      minFrequent = 1;
      return;
    }
    remove(node);
    node.value = value;
    addNode(node);
  }

  private Node remove(Node node) {
    Set<Integer> keys = frequentToKey.get(node.frequent);
    keys.remove(node.key);
    if (node.frequent == minFrequent && keys.isEmpty()) {
      minFrequent++;
    }
    node.frequent = node.frequent+1;
    return node;
  }

  private void addNode(Node node) {
    keyToNode.put(node.key, node);
    Set<Integer> setToAdd = frequentToKey.get(node.frequent);
    if (setToAdd == null) {
      setToAdd = new LinkedHashSet<>();
      frequentToKey.put(node.frequent, setToAdd);
    }
    setToAdd.add(node.key);
  }
}
