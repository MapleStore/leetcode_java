package darren.gong.leetcode;

public class IsAlienSorted935 {
  private int[] index;
  public boolean isAlienSorted(String[] words, String order) {
    index = new int[26];
    for (int i = 0; i < 26; i++) {
      index[order.charAt(i)-'a'] = i;
    }
    int length = words.length;
    for (int i = 0; i < length-1; i++) {
      if (!smaller(words[i], words[i+1])) {
        return false;
      }
    }
    return true;
  }
  private boolean smaller(String small, String big) {
    for (int i = 0; i < small.length(); i++) {
      if (i >= big.length()) {
        return false;
      }
      if (index[small.charAt(i)-'a'] > index[big.charAt(i)-'a']) {
        return false;
      } else if (index[small.charAt(i)-'a'] < index[big.charAt(i)-'a']) {
        return true;
      }
    }
    return true;
  }
}
