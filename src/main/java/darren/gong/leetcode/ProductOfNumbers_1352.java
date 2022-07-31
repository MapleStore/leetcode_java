package darren.gong.leetcode;

import java.util.ArrayList;

public class ProductOfNumbers_1352 {
  // 1352. 最后 K 个数的乘积
  private int currentValue = 0;
  private int lastZeroIndex = -1;
  private ArrayList<Integer> list = new ArrayList<>();
  public ProductOfNumbers_1352() {

  }

  public void add(int num) {
    if (currentValue == 0) {
      currentValue = num;
    } else {
      currentValue *= num;
    }
    list.add(currentValue);
    if (currentValue == 0) {
      lastZeroIndex = list.size()-1;
    }
  }

  public int getProduct(int k) {
    if (list.size()-k-1 < lastZeroIndex) {
      return 0;
    }
    if (list.size()-k-1 == lastZeroIndex) {
      return list.get(list.size()-1);
    }
    int left = list.size()-k-1 >= 0 ? list.get(list.size()-k-1) : 1;
    int right = list.get(list.size()-1);
    return right/left;
  }
}
