package darren.gong.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupStrings_249 {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String one : strings) {
      char[] chars = one.toCharArray();
      int distance = chars[0]-'a';
      for (int i = 0; i < chars.length; i++) {
        if (chars[i] < 'a'+distance) {
          chars[i] += 26;
        }
        chars[i] -= distance;
      }
      List<String> group = map.computeIfAbsent(new String(chars), k->new LinkedList<>());
      group.add(one);
    }
    return new LinkedList<>(map.values());
  }
}
