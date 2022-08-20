package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SmallestStringWithSwaps_1202 {
  public static void main(String[] args) {
    SmallestStringWithSwaps_1202 smallestStringWithSwaps_1202 = new SmallestStringWithSwaps_1202();
    smallestStringWithSwaps_1202.smallestStringWithSwaps("dcab",
        Arrays.asList(Arrays.asList(0,3), Arrays.asList(1,2), Arrays.asList(0,2)));
  }
  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
    Map<Integer, Set<Integer>> links = new HashMap<>();
    for (List<Integer> pair : pairs) {
      Set<Integer> next0 = links.computeIfAbsent(pair.get(0), k->new HashSet<>());
      next0.add(pair.get(1));
      Set<Integer> next1 = links.computeIfAbsent(pair.get(1), k->new HashSet<>());
      next1.add(pair.get(0));
    }
    boolean[] visited = new boolean[s.length()];
    int[] parents = new int[s.length()];
    Arrays.fill(parents, -1);
    for (int i = 0; i < s.length(); i++) {
      if (visited[i]) {
        continue;
      }
      Queue<Integer> queue = new LinkedList<>();
      queue.add(i);
      visited[i] = true;
      parents[i] = i;
      while (!queue.isEmpty()) {
        int current = queue.poll();
        Set<Integer> allNext = links.get(current);
        if (allNext == null) {
          continue;
        }
        for (int next : allNext) {
          if (visited[next]) {
            continue;
          }
          queue.add(next);
          visited[next] = true;
          parents[next] = i;
        }
      }
    }
    char[] charArr = s.toCharArray();
    Map<Integer, List<Integer>> allLinkedIndex = new HashMap<>();
    Map<Integer, List<Character>> allChars = new HashMap<>();
    for (int i = 0; i < parents.length; i++) {
      int parent = parents[i];
      if (parent == -1) {
        continue;
      }
      List<Integer> linkedIndex = allLinkedIndex.computeIfAbsent(parent, k->new ArrayList<>());
      linkedIndex.add(i);

      List<Character> chars = allChars.computeIfAbsent(parent, k->new ArrayList<>());
      chars.add(charArr[i]);
    }
    for (Integer parent : allLinkedIndex.keySet()) {
      List<Integer> linkedIndex = allLinkedIndex.get(parent);
      Collections.sort(linkedIndex);
      List<Character> chars = allChars.get(parent);
      Collections.sort(chars);

      int charIndex = 0;
      for (int fillIndex : linkedIndex) {
        charArr[fillIndex] = chars.get(charIndex++);
      }
    }

    return new String(charArr);
  }
}
