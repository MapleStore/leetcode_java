package darren.gong.leetcode;

public class CanConstruct383 {
  public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote == null || magazine == null) {
      if (ransomNote == magazine) {
        return true;
      }
      return false;
    }
    if (ransomNote.length() > magazine.length()) {
      return false;
    }
    int[] map = new int[26];
    for (char oneChar : ransomNote.toCharArray()) {
      map[oneChar-'a']++;
    }
    for (char oneChar : magazine.toCharArray()) {
      map[oneChar-'a']--;
    }
    for (int num : map) {
      if (num > 0) {
        return false;
      }
    }
    return true;
  }
}
