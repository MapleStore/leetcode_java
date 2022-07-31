package darren.gong.leetcode;

public class SortString1370 {
  public static void main(String[] args) {
    SortString1370 sortString1370 = new SortString1370();
    sortString1370.sortString("aaabbbccc");
  }
  public String sortString(String s) {
    int[] source = new int[26];
    for (char oneChar : s.toCharArray()) {
      source[oneChar-'a']++;
    }
    int length = s.length();
    int index = 0;
    StringBuilder sb = new StringBuilder();
    while (index < length) {
      for (int i = 0; i < 26; i++) {
        if (source[i] > 0) {
          sb.append((char)(i+'a'));
          source[i]--;
          index++;
        }
      }
      for (int i = 25; i >= 0; i--) {
        if (source[i] > 0) {
          sb.append((char)(i+'a'));
          source[i]--;
          index++;
        }
      }
    }
    return sb.toString();
  }
}
