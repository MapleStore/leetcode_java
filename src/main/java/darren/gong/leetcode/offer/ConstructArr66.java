package darren.gong.leetcode.offer;

public class ConstructArr66 {
  public int[] constructArr(int[] a) {
    int length = a.length;
    int[] left = new int[length];
    int[] right = new int[length];
    int num = 1;
    for (int i = 0; i < length; i++) {
      left[i] = num;
      num *= a[i];
    }
    num = 1;
    for (int i = length-1; i >= 0; i--) {
      right[i] = num;
      num *= a[i];
    }
    for (int i = 0; i < length; i++) {
      a[i] = left[i] * right[i];
    }
    return a;
  }
}
