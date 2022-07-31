package darren.gong.leetcode.interview;

public class IsUnique0101 {
  public boolean isUnique(String astr) {
    if (astr == null || astr.length() == 0) {
      return true;
    }
    boolean[] appear = new boolean[26];
    for (char oneChar : astr.toCharArray()) {
      if (appear[oneChar-'a'])
        return false;
      appear[oneChar-'a'] = true;
    }
    return true;
  }
}
