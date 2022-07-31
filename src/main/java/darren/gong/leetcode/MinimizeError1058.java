package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimizeError1058 {
  public static void main(String[] args) {
    int value = 1000000*1000;
    System.out.println(value);
  }
  private int prePoint = 0;
  private List<Integer> afterPoint;
  public String minimizeError(String[] prices, int target) {
    int length = prices.length;
    afterPoint = new ArrayList<>(length);
    process(prices);
    target -= prePoint;
    if (target < 0 || afterPoint.size() < target) {
      return "-1";
    }
    target *= 1000;
    Collections.sort(afterPoint, (a, b)->b-a);

    int resultInt = 0;
    for (int i = 0; i < afterPoint.size(); i++) {
      if (target > 0) {
        target -= 1000;
        resultInt += 1000-afterPoint.get(i);
      } else {
        resultInt += afterPoint.get(i);
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(resultInt/1000).append(".");
    if (resultInt%1000 < 100) {
      sb.append(0);
    }
    if (resultInt%1000 < 10) {
      sb.append(0);
    }
    sb.append(resultInt%1000);
    return sb.toString();
  }

  private void process(String[] prices) {
    for (String price : prices) {
      String[] splitPrice = price.split("\\.");
      prePoint += Integer.parseInt(splitPrice[0]);
      int afterPointInt = 0;
      for (int i = 0; i < 3; i++) {
        afterPointInt = afterPointInt*10+splitPrice[1].charAt(i)-'0';
      }
      if (afterPointInt != 0) {
        afterPoint.add(afterPointInt);
      }
    }
  }
}
