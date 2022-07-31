package darren.gong.leetcode;

public class Decode_1734 {
  // 1734. 解码异或后的排列
  public int[] decode(int[] encoded) {
    int n = encoded.length+1;
    int allXOR = 0;
    for (int i = 1; i <= n; i++) {
      allXOR = i ^ allXOR;
    }

    for (int i = encoded.length-1; i >= 0; i -= 2) {
      allXOR = allXOR^encoded[i];
    }
    int firstVal = allXOR;
    int[] result = new int[n];
    result[0] = firstVal;
    for (int i = 1; i < n; i++) {
      result[i] = encoded[i-1]^result[i-1];
    }
    return result;
  }
}
