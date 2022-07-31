package darren.gong.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MultiSearch_1717 {
  // 简单查找，缓存每个字母的出现位置作为优化
  public int[][] multiSearch(String big, String[] smalls) {
    Queue<Integer>[] starts = new Queue[26];
    for (int i = 0; i < 26; i++) {
      starts[i] = new LinkedList<>();
    }
    char[] chars = big.toCharArray();
    int bigLength = big.length();
    for (int i = 0; i < bigLength; i++) {
      starts[chars[i]-'a'].add(i);
    }
    int resultLength = smalls.length;
    int[][] result = new int[resultLength][];
    for (int i = 0; i < resultLength; i++) {
      String small = smalls[i];
      if (small.isEmpty()) {
        result[i] = new int[0];
        continue;
      }
      Queue<Integer> queue = starts[small.charAt(0)-'a'];
      List<Integer> oneResult = new ArrayList<>();
      for (int startIndex : queue) {
        if (big.startsWith(small, startIndex)) {
          oneResult.add(startIndex);
        }
      }
      int[] temp = new int[oneResult.size()];
      int index = 0;
      for (int startIndex : oneResult) {
        temp[index++] = startIndex;
      }
      result[i] = temp;
    }
    return result;
  }

  // map做法 超时
  public int[][] multiSearchMap(String big, String[] smalls) {
    Map<String, List<Integer>> map = new HashMap<>();
    char[] chars = big.toCharArray();
    int bigLength = big.length();
    for (int i = 0; i < bigLength; i++) {
      for (int j = i+1; j <= bigLength; j++) {
        String value = new String(chars, i, j-i);
        map.computeIfAbsent(value, k->new ArrayList<>()).add(i);
      }
    }

    int resultLength = smalls.length;
    int[][] result = new int[resultLength][];
    for (int i = 0; i < resultLength; i++) {
      String small = smalls[i];
      List<Integer> oneResult = map.get(small);
      if (oneResult == null || oneResult.isEmpty()) {
        result[i] = new int[0];
        continue;
      }
      int[] temp = new int[oneResult.size()];
      int index = 0;
      for (int startIndex : oneResult) {
        temp[index++] = startIndex;
      }
      result[i] = temp;
    }
    return result;
  }

}
