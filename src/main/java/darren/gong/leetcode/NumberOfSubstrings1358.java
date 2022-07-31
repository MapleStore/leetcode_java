package darren.gong.leetcode;

public class NumberOfSubstrings1358 {
  public int numberOfSubstrings(String s) {
    char[] arr = s.toCharArray();
    int left = 0;
    int right = 0;
    int length = arr.length;
    int[] num = new int[3];
    int currentAppear = 0;
    int result = 0;
    while (right < length) {
      num[arr[right]-'a']++;
      if (num[arr[right]-'a'] == 1) {
        currentAppear++;
      }
      while (currentAppear >= 3) {
        result += length-right;
        num[arr[left]-'a']--;
        if (num[arr[left]-'a'] == 0) {
          currentAppear--;
        }
        left++;
      }
      right++;
    }
    return result;
  }
}
