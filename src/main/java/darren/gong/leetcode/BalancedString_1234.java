package darren.gong.leetcode;

public class BalancedString_1234 {
  // 1234. 替换子串得到平衡字符串
  public int balancedString(String s) {
    char[] chars = s.toCharArray();
    int targetNum = s.length()/4;
    int[] count = new int[26];
    for (char oneChar : chars) {
      count[oneChar-'A']++;
    }
    boolean[] needReplace = new boolean[26];
    int needReplaceNum = 0;
    for (int i = 0; i < 26; i++) {
      if (count[i] > targetNum) {
        count[i] -= targetNum;
        needReplace[i] = true;
        needReplaceNum++;
      }
    }
    if (needReplaceNum == 0) {
      return 0;
    }
    int left = 0;
    int right = 0;
    int result = Integer.MAX_VALUE;
    while (right < chars.length) {
      char rightChar = chars[right];
      if (needReplace[rightChar-'A']) {
        count[rightChar-'A']--;
        if (count[rightChar-'A'] == 0) {
          needReplaceNum--;
        }
        if (needReplaceNum == 0) {
          result = Math.min(result, right-left+1);
        }
      }

      while (!needReplace[chars[left]-'A'] || count[chars[left]-'A'] < 0) {
        if (needReplace[chars[left]-'A']) {
          count[chars[left]-'A']++;
        }
        left++;
      }
      if (needReplaceNum == 0) {
        result = Math.min(result, right-left+1);
      }
      right++;
    }
    return result;
  }
}
