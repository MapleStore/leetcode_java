package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SplitIntoFibonacci842 {
  private List<Integer> result;
  public List<Integer> splitIntoFibonacci(String num) {
    dfs(0, num, new ArrayList<>());
    return result == null ? new ArrayList<>() : result;
  }
  private void dfs(int index, String num, List<Integer> list) {
    if (result != null) {
      return;
    }
    if (index == num.length()) {
      if (list.size() >= 3) {
        result = new ArrayList<>(list);
      }
      return;
    }
    if (list.size() >= 2) {
      long currentValue = list.get(list.size()-1)+list.get(list.size()-2);
      if (currentValue >= Integer.MAX_VALUE) {
        return;
      }
      String current = String.valueOf(currentValue);
      if (num.startsWith(current, index)) {
        list.add((int)currentValue);
        dfs(index+current.length(), num, list);
        list.remove(list.size()-1);
      }
      return;
    }
    for (int i = index+1; i <= num.length(); i++) {
      String current = num.substring(index, i);
      if (current.length() > 1 && current.startsWith("0")) {
        break;
      }
      long currentValue = Long.parseLong(current);
      if (currentValue >= Integer.MAX_VALUE) {
        break;
      }
      list.add(Integer.parseInt(current));
      dfs(i, num, list);
      list.remove(list.size()-1);
    }
  }
}
