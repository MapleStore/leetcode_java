package darren.gong.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap706 {
    private class Pair {
        private int key;
        private int value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int mask = 2<<13-1;
    private List<Pair>[] array = new LinkedList[mask+1];
    /** Initialize your data structure here. */
    public MyHashMap706() {
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key&mask;
        if (array[index] == null) {
            array[index] = new LinkedList<>();
            array[index].add(new Pair(key, value));
            return;
        }
        List<Pair> pairs = array[index];
        for (Pair pair : pairs) {
            if (pair.key == key) {
                pair.value = value;
                return;
            }
        }
        pairs.add(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key&mask;
        List<Pair> pairs = array[index];
        if (pairs == null) {
            return -1;
        }
        for (Pair pair : pairs) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key&mask;
        List<Pair> pairs = array[index];
        if (pairs == null) {
            return;
        }
        for (Pair pair : pairs) {
            if (pair.key == key) {
                pairs.remove(pair);
                return;
            }
        }
    }
}
