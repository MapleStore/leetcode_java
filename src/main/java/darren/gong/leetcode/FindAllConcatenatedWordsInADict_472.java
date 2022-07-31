package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class FindAllConcatenatedWordsInADict_472 {
  private List<String> result = new LinkedList<>();
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Arrays.sort(words, (a,b)->a.length()-b.length());
    TreeMap<Integer, Set<String>> map = new TreeMap<>();
    for (String word : words) {
      if (word.length() == 0) {
        continue;
      }
      dfs(word, 0, map, new HashSet<>());
      Set<String> strings = map.computeIfAbsent(word.length(), k->new HashSet<>());
      strings.add(word);
    }
    return result;
  }
  private boolean dfs(String word, int index, TreeMap<Integer, Set<String>> map, HashSet<Integer> visited) {
    if (visited.contains(index)) {
      return false;
    }
    if (index == word.length()) {
      result.add(word);
      return true;
    }
    for (Map.Entry<Integer, Set<String>> entry : map.entrySet()) {
      if (index+entry.getKey() > word.length()) {
        break;
      }
      if (!entry.getValue().contains(word.substring(index, index+entry.getKey()))) {
        continue;
      }
      if (dfs(word, index+entry.getKey(), map, visited)) {
        return true;
      }
    }
    visited.add(index);
    return false;
  }
}
