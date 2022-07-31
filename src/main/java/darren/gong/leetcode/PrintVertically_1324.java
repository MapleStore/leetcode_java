package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PrintVertically_1324 {
  public static void main(String[] args) {
    PrintVertically_1324 printVertically_1324 = new PrintVertically_1324();
    printVertically_1324.printVertically("HOW ARE YOU");
  }
  public List<String> printVertically(String s) {
    s = s.trim();
    String[] arr = s.split(" ");
    int currentIndex = 0;
    ArrayList<StringBuilder> result = new ArrayList<>();
    while (true) {
      StringBuilder current = new StringBuilder();
      for (int i = 0; i < arr.length; i++) {
        if (currentIndex >= arr[i].length()) {
          current.append(" ");
        } else {
          current.append(arr[i].charAt(currentIndex));
        }
      }
      if (current.toString().trim().isEmpty()) {
        break;
      }
      result.add(current);
      currentIndex++;
    }
    ArrayList<String> realResult = new ArrayList<>();
    for (StringBuilder sb : result) {
      while (sb.charAt(sb.length()-1) == ' ') {
        sb.deleteCharAt(sb.length()-1);
      }
      realResult.add(sb.toString());
    }
    return realResult;
  }
}
