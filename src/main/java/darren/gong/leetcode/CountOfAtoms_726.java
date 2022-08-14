package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountOfAtoms_726 {
  private int index = 0;
  public String countOfAtoms(String formula) {
    StringBuilder sb = new StringBuilder();
    Map<String, Integer> map = visit(formula.toCharArray());
    TreeMap<String, Integer> treeMap = new TreeMap<>(map);
    for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
      sb.append(entry.getKey()).append(entry.getValue() == 1 ? "" : entry.getValue());
    }
    return sb.toString();
  }
  private Map<String, Integer> visit(char[] formula) {
    Map<String, Integer> map = new HashMap<>();
    for (; index < formula.length;) {
      if (formula[index] <= 'Z' && formula[index] >= 'A') {
        StringBuilder sb = new StringBuilder();
        sb.append(formula[index++]);
        while (index < formula.length && formula[index] >= 'a' && formula[index] <= 'z') {
          sb.append(formula[index++]);
        }
        int val = 0;
        while (index < formula.length && formula[index] >= '0' && formula[index] <= '9') {
          val = val*10 + formula[index++]-'0';
        }
        map.put(sb.toString(), map.getOrDefault(sb.toString(), 0)+Math.max(1, val));
      } else if (formula[index] == '(') {
        index++;
        Map<String, Integer> tempVal = visit(formula);
        int val = 0;
        while (index < formula.length && formula[index] >= '0' && formula[index] <= '9') {
          val = val*10 + formula[index++]-'0';
        }
        val = Math.max(1, val);
        for (Map.Entry<String, Integer> entry : tempVal.entrySet()) {
          map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0)+entry.getValue()*val);
        }
      } else {
        index++;
        break;
      }
    }
    return map;
  }
}
