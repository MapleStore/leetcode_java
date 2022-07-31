package darren.gong.leetcode;

public class KthGrammar779 {
  public int kthGrammar(int N, int K) {
    if (N == 1) {
      return 0;
    }
    int lastIndex = K>>>1;
    return K == (lastIndex<<1) ? 1-kthGrammar(N-1, lastIndex) : kthGrammar(N-1, lastIndex+1);
  }
}
