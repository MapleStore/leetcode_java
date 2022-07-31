package darren.gong.leetcode;

import java.util.HashMap;
import java.util.Map;

public class GetFolderNames_1487 {
  // 1487. 保证文件名唯一
  public static void main(String[] args) {
    GetFolderNames_1487 getFolderNames_1487 = new GetFolderNames_1487();
    getFolderNames_1487.getFolderNames(new String[]{"s","z","s","s","s(2)"});
  }
  Map<String, Integer> currentIndex = new HashMap<>();
  public String[] getFolderNames(String[] names) {
    int length = names.length;
    for (int i = 0; i < length; i++) {
      if (!contains(names[i])) {
        currentIndex.put(names[i], 1);
        continue;
      }
      int postfix = currentIndex.getOrDefault(names[i], 1);
      StringBuilder sb = new StringBuilder(names[i]);
      while (currentIndex.containsKey(sb.append('(').append(postfix).append(')').toString())) {
        sb.deleteCharAt(sb.length()-1);
        sb.delete(sb.length()-String.valueOf(postfix).length(), sb.length());
        sb.deleteCharAt(sb.length()-1);
        postfix++;
      }
      currentIndex.put(names[i], postfix+1);
      names[i] = sb.toString();
    }
    return names;
  }

  private boolean contains(String name) {
    if (name.length() <= 3) {
      return currentIndex.containsKey(name);
    }
    if (name.charAt(name.length()-1) != ')') {
      return currentIndex.containsKey(name);
    }
    int leftIndex = name.lastIndexOf('(');
    int num = getDigit(name.substring(leftIndex+1, name.length()-1));
    if (leftIndex == -1 || num == -1) {
      return currentIndex.containsKey(name);
    }
    String preName = name.substring(0, leftIndex);
    int value = currentIndex.getOrDefault(preName, -1);
    return value > num || currentIndex.containsKey(name);
  }
  private int getDigit(String num) {
    try {
      return Integer.parseInt(num);
    } catch (Exception e) {
      return -1;
    }
  }
}
