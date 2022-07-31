package darren.gong.leetcode.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class FindClosest_1711 {
  public int findClosest(String[] words, String word1, String word2) {
    Map<String, TreeSet<Integer>> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      TreeSet<Integer> treeSet = map.computeIfAbsent(words[i], k->new TreeSet<>());
      treeSet.add(i);
    }

    TreeSet<Integer> word1Set = map.getOrDefault(word1, new TreeSet<>());
    TreeSet<Integer> word2Set = map.getOrDefault(word2, new TreeSet<>());
    int distance = Integer.MAX_VALUE;
    for (int word1Index : word1Set) {
      Integer down = word2Set.lower(word1Index);
      if (down != null) {
        distance = Math.min(distance, word1Index-down);
      }
      Integer high = word2Set.higher(word1Index);
      if (high != null) {
        distance = Math.min(distance, high-word1Index);
      }
    }
    return distance;
  }
}
