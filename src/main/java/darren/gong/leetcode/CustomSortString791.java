package darren.gong.leetcode;

public class CustomSortString791 {
  public String customSortString(String S, String T) {
    int[] appears = new int[26];
    for (char oneChar : T.toCharArray()) {
      appears[oneChar-'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (char oneChar : S.toCharArray()) {
      while (appears[oneChar-'a'] > 0) {
        sb.append(oneChar);
        appears[oneChar-'a']--;
      }
    }
    for (int i = 0; i < appears.length; i++) {
      while (appears[i] > 0) {
        sb.append((char)(i+'a'));
        appears[i]--;
      }
    }
    return sb.toString();
  }
}
