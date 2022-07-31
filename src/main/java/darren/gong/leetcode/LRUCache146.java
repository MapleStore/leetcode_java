package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    public static void main(String[] args) {
        LRUCache146 lruCache146 = new LRUCache146(2);
        lruCache146.put(1,1);
        lruCache146.put(2,2);
        lruCache146.get(1);
        lruCache146.put(3,3);
        lruCache146.get(2);
        lruCache146.put(4,4);
        lruCache146.get(1);
        lruCache146.get(3);
        lruCache146.get(4);



    }
    private int capacity;
    private Map<Integer, Entry> map = new HashMap<Integer, Entry>();
    Entry head;
    Entry end;
    private class Entry {
        private int key;
        private int val;
        private Entry pre;
        private Entry next;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    public LRUCache146(int capacity) {
        this.capacity = capacity;
        head = new Entry(-1, -1);
        end = new Entry(-1, -1);
        head.next = end;
        end.pre = head;
    }

    public int get(int key) {
        Entry entry = map.get(key);
        if (entry == null) {
            return -1;
        }
        entry.next.pre = entry.pre;
        entry.pre.next = entry.next;
        entry.pre = head;
        entry.next = head.next;
        head.next = entry;
        entry.next.pre = entry;
        return entry.val;
    }

    public void put(int key, int value) {
        unlink(key);
        map.remove(key);
        if (map.size() == capacity) {
            Entry remove = end.pre;
            map.remove(remove.key);
            remove.pre.next = remove.next;
            remove.next.pre = remove.pre;
            remove.pre = null;
            remove.next = null;
        }
        Entry entry = new Entry(key, value);
        entry.next = head.next;
        entry.pre = head;
        entry.next.pre = entry;
        head.next = entry;
        map.put(key, entry);
    }

    private void unlink(int key) {
        Entry entry = map.get(key);
        if (entry == null) {
            return;
        }
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
        entry.pre = null;
        entry.next = null;
    }
}
