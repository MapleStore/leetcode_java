package darren.gong.leetcode;

public class GcdOfStrings1071 {
  public String gcdOfStrings(String str1, String str2) {
    if (str1.equals(str2)) {
      return str1;
    }
    if (str2.length() > str1.length()) {
      String temp = str1;
      str1 = str2;
      str2 = temp;
    }
    if (!str1.startsWith(str2)) {
      return "";
    }
    return gcdOfStrings(str1.substring(str2.length()), str2);
  }
}
