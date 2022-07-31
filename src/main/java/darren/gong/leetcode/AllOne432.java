package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllOne432 {
  public static void main(String[] args) {
    AllOne432 allOne432 = new AllOne432();
    allOne432.inc("aaa");
    allOne432.inc("aaa");
    allOne432.inc("aaa");
    allOne432.inc("bbb");
    allOne432.dec("aaa");
    System.out.println(allOne432.getMaxKey());
    System.out.println(allOne432.getMinKey());
    allOne432.dec("bbb");
    System.out.println(allOne432.getMaxKey());
    System.out.println(allOne432.getMinKey());
  }
  private class Entry {
    private Entry pre;
    private Entry next;
    Set<String> keySet = new HashSet<>();
  }
  private Entry head = new Entry();// min
  private Entry tail = new Entry();// max
  private Map<String, Integer> keyToValue = new HashMap<>();
  private Map<Integer, Entry> valueToKeys = new HashMap<>();

  /** Initialize your data structure here. */
  public AllOne432() {
    head.next = tail;
    tail.pre = head;
  }

  /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
  public void inc(String key) {
    Integer value = keyToValue.get(key);
    // 原来没有这个key
    if (value == null) {
      keyToValue.put(key, 1);

      Entry entryToAdd = valueToKeys.get(1);
      if (entryToAdd == null) {
        entryToAdd = new Entry();
        entryToAdd.next = head.next;
        entryToAdd.next.pre = entryToAdd;
        entryToAdd.pre = head;
        entryToAdd.pre.next = entryToAdd;
        valueToKeys.put(1, entryToAdd);
      }
      entryToAdd.keySet.add(key);
      return;
    }
    // 原来有这个key, 把key从原来位置删除, 放入下一位置
    Entry entryToDelete = valueToKeys.get(value);
    entryToDelete.keySet.remove(key);
    int nextValue = value+1;
    keyToValue.put(key, nextValue);

    Entry entryToAdd = valueToKeys.get(nextValue);
    if (entryToAdd == null) {
      entryToAdd = new Entry();
      entryToAdd.pre = entryToDelete;
      entryToAdd.next = entryToDelete.next;
      entryToAdd.pre.next = entryToAdd;
      entryToAdd.next.pre = entryToAdd;
      valueToKeys.put(nextValue, entryToAdd);
    }
    entryToAdd.keySet.add(key);

    // 失去key的entry为空的话删除
    if (entryToDelete.keySet.isEmpty()) {
      entryToDelete.next.pre = entryToDelete.pre;
      entryToDelete.pre.next = entryToDelete.next;
      valueToKeys.remove(value);
    }
  }

  /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
  public void dec(String key) {
    Integer value = keyToValue.get(key);
    // 原来没有这个key
    if (value == null) {
      return;
    }
    // 原来有这个key, 把key从原来位置删除, 放入下一位置
    Entry entryToDelete = valueToKeys.get(value);
    entryToDelete.keySet.remove(key);
    int nextValue = value-1;

    if (nextValue != 0) {
      keyToValue.put(key, nextValue);

      Entry entryToAdd = valueToKeys.get(nextValue);
      if (entryToAdd == null) {
        entryToAdd = new Entry();
        entryToAdd.pre = entryToDelete.pre;
        entryToAdd.next = entryToDelete;
        entryToAdd.pre.next = entryToAdd;
        entryToAdd.next.pre = entryToAdd;
        valueToKeys.put(nextValue, entryToAdd);
      }
      entryToAdd.keySet.add(key);
      keyToValue.put(key, nextValue);
    } else {
      keyToValue.remove(key);
    }

    // 失去key的entry为空的话删除
    if (entryToDelete.keySet.isEmpty()) {
      entryToDelete.next.pre = entryToDelete.pre;
      entryToDelete.pre.next = entryToDelete.next;
      valueToKeys.remove(value);
    }
  }

  /** Returns one of the keys with maximal value. */
  public String getMaxKey() {
    if (tail.pre == head) {
      return "";
    }
    return tail.pre.keySet.iterator().next();
  }

  /** Returns one of the keys with Minimal value. */
  public String getMinKey() {
    if (head.next == tail) {
      return "";
    }
    return head.next.keySet.iterator().next();
  }
}
