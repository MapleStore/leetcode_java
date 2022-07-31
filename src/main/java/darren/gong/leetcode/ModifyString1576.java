package darren.gong.leetcode;

public class ModifyString1576 {
  public String modifyString(String s) {
    char[] arr = s.toCharArray();
    int length = s.length();
    char pre = '?';
    for (int i = 0; i < length; i++) {
      if (arr[i] == '?') {
        arr[i] = getFillValue(pre, i == length-1 ? '?' : arr[i+1]);
      }
      pre = arr[i];
    }
    return new String(arr);
  }
  private char getFillValue(char pre, char end) {
    for (int i = 'a'; i <= 'z'; i++) {
      if (i != pre && i != end) {
        return (char)i;
      }
    }
    return '?';
  }
}
