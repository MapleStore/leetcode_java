package darren.gong.leetcode.AlgorithmDemo;

public class KMP {
  public static void main(String[] args) {
    KMP kmp = new KMP();
    int[] result = kmp.getNext("abababaac"); // 0 0 1 2 3 1 0
    for (int val : result) {
      System.out.print(val+" ");
    }
  }
  private int[] getNext(String s) {
    int length = s.length();
    int[] next = new int[length];
    next[0] = 0;
    for (int i = 1, j = 0; i < length; i++) {
      while (j > 0 && s.charAt(i) != s.charAt(j)) {
        j = next[j-1];
      }
      if (s.charAt(j) == s.charAt(i)) j++;
      next[i] = j;
    }
    return next;
  }
  private int[] getNextBook(String s) {
    s = " "+s;
    int length = s.length();
    int[] next = new int[length];
    next[1] = 0;
    for (int i = 2, j = 0; i < length; i++) {
      while (j > 0 && s.charAt(i) != s.charAt(j+1)) {
        j = next[j];
      }
      if (s.charAt(j+1) == s.charAt(i)) j++;
      next[i] = j;
    }
    return next;
  }
}
