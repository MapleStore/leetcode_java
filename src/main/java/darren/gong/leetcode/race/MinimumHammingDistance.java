package darren.gong.leetcode.race;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumHammingDistance {
  public static void main(String[] args) {
    MinimumHammingDistance minimumHammingDistance = new MinimumHammingDistance();
    minimumHammingDistance.minimumHammingDistance(new int[]{71,13,6,60,22,31}, new int[]{66,57,2,60,22,73}, new int[][]{{4,5},{0,4}});
  }
  public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
    int n = source.length;
    int[] parents = new int[n];
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
    for (int[] allowSwap : allowedSwaps) {
      parents[findParent(parents, allowSwap[1])] = parents[findParent(parents, allowSwap[0])];
    }

    int result = 0;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      map.putIfAbsent(findParent(parents, i), new HashSet<>());
      map.get(parents[i]).add(i);
    }

    for (Integer key : map.keySet()) {
      if (map.get(key).size() == 1) {
        if (source[key] != target[key]) {
          result++;
        }
        continue;
      }
      result += countDistance(map.get(key), source, target);
    }
    return result;
  }
  private int findParent(int[] parents, int p) {
    if (parents[p] == p) {
      return p;
    }
    parents[p] = findParent(parents, parents[p]);
    return parents[p];
  }
  private int countDistance(Set<Integer> set, int[] source, int[] target) {
    Map<Integer, Integer> sourceCount = new HashMap<>();
    for (int sourceIndex : set) {
      sourceCount.put(source[sourceIndex], sourceCount.getOrDefault(source[sourceIndex], 0)+1);
    }
    Map<Integer, Integer> targetCount = new HashMap<>();
    for (int targetIndex : set) {
      targetCount.put(target[targetIndex], targetCount.getOrDefault(target[targetIndex], 0)+1);
    }

    int same = 0;
    for (int key : sourceCount.keySet()) {
      same += Math.min(sourceCount.get(key), targetCount.getOrDefault(key, 0));
    }
    return set.size()-same;
  }
}
