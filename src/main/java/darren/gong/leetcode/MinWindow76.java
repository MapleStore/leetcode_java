package darren.gong.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MinWindow76 {
  public String minWindow(String s, String t) {
    if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
      return "";
    }
    Map<Character, Queue<Integer>> charToLastIndex = new HashMap<>();
    Map<Character, Integer> charToSize = new HashMap<>();
    for (char one : t.toCharArray()) {
      charToLastIndex.put(one, new LinkedList<>());
      charToSize.put(one, charToSize.getOrDefault(one, 0)+1);
    }
    char[] sChar = s.toCharArray();
    StringBuilder sb = new StringBuilder(s);
    String result = "";
    long minLength = Long.MAX_VALUE;
    for (int i = 0; i < s.length(); i++) {
      if (!charToLastIndex.containsKey(sChar[i])) {
        continue;
      }
      Queue<Integer> queue = charToLastIndex.get(sChar[i]);
      charToLastIndex.get(sChar[i]).add(i);
      if (queue.size() > charToSize.get(sChar[i])) {
        queue.poll();
      }
      int startIndex = Integer.MAX_VALUE;
      for (Map.Entry<Character, Queue<Integer>> entry : charToLastIndex.entrySet()) {
        if (entry.getValue().size() < charToSize.get(entry.getKey())) {
          startIndex = Integer.MAX_VALUE;
          break;
        }
        startIndex = Math.min(startIndex, entry.getValue().peek());
      }
      if (startIndex != Integer.MAX_VALUE && i-startIndex < minLength) {
        minLength = i - startIndex;
        result = sb.substring(startIndex, i+1);
      }
    }
    return result;
  }
}
