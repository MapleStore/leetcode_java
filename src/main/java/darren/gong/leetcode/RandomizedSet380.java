package darren.gong.leetcode;

import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet380 {
    private Map<Integer, Integer> valueToIndex;
    private ArrayList<Integer> array;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedSet380() {
        array = new ArrayList<>();
        valueToIndex = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valueToIndex.containsKey(val)) {
            return false;
        }
        int index = array.size();
        array.add(index, val);
        valueToIndex.put(val, index);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valueToIndex.containsKey(val)) {
            return false;
        }
        int indexToRemove = valueToIndex.get(val);
        int lastValue = array.get(array.size()-1);
        valueToIndex.put(lastValue, indexToRemove);
        array.set(indexToRemove, lastValue);
        array.remove(array.size()-1);
        valueToIndex.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(random.nextInt(array.size()));
    }

}
