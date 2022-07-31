package darren.gong.leetcode.race;

public class Decode {
  public int[] decode(int[] encoded, int first) {
    if (encoded == null) {
      return null;
    }
    if (encoded.length == 0) {
      return new int[]{first};
    }
    int length = encoded.length;
    int[] result = new int[length+1];
    result[0] = first;
    for (int i = 1; i <= length; i++) {
      result[i] = result[i-1]^encoded[i-1];
    }
    return result;
  }
}
