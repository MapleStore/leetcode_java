package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection_381 {
  public static void main(String[] args) {
    RandomizedCollection_381 randomizedCollection_381 = new RandomizedCollection_381();
    randomizedCollection_381.insert(0);
    randomizedCollection_381.insert(1);
    randomizedCollection_381.remove(0);
    randomizedCollection_381.insert(2);
    randomizedCollection_381.remove(1);
    randomizedCollection_381.getRandom();
  }
  private ArrayList<Integer> list = new ArrayList<>();
  private Map<Integer, Set<Integer>> map = new HashMap<>();
  private Random random = new Random();
  public RandomizedCollection_381() {

  }

  public boolean insert(int val) {
    list.add(val);
    Set<Integer> positions = map.computeIfAbsent(val, k->new HashSet<>());
    positions.add(list.size()-1);
    return positions.size() == 1;
  }

  public boolean remove(int val) {
    Set<Integer> positions = map.computeIfAbsent(val, k->new HashSet<>());
    if (positions.isEmpty()) {
      return false;
    }
    Iterator<Integer> iterator = positions.iterator();
    int removePosition = iterator.next();
    if (removePosition == list.size()-1) {
      list.remove(removePosition);
      iterator.remove();
    } else {
      int lastIndex = list.size()-1;
      int lastVal = list.get(lastIndex);
      map.get(lastVal).remove(lastIndex);
      map.get(val).remove(removePosition);
      map.get(lastVal).add(removePosition);
      list.set(removePosition, lastVal);
      list.remove(lastIndex);
    }
    return true;
  }

  public int getRandom() {
    if (list.size() == 0) {
      return -1;
    }
    int pos = random.nextInt(list.size());
    return list.get(pos);
  }
}
