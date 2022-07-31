package darren.gong.leetcode;

public class LengthOfLastWord58 {
  public static void main(String[] args) {
    LengthOfLastWord58 lengthOfLastWord58 = new LengthOfLastWord58();
    lengthOfLastWord58.lengthOfLastWord("aaaaa   ");
  }
  public int lengthOfLastWord(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int index = s.length()-1;
    while (index >= 0 && s.charAt(index) == ' ') {
      index--;
    }
    if (index == -1) return 0;

    int preIndex = index;
    while (preIndex >= 0 && s.charAt(preIndex) != ' ') {
      preIndex--;
    }
    return index-preIndex;
  }
}
