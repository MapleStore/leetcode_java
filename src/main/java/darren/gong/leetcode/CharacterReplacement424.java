package darren.gong.leetcode;

public class CharacterReplacement424 {
  public int characterReplacement(String s, int k) {
    char[] arr = s.toCharArray();
    int length = s.length();
    int result = Math.min(k+1, s.length());
    int right = 0;
    int left = 0;
    int[] appears = new int[26];
    while (right < length) {
      appears[arr[right]-'A']++;
      if (canReach(appears, right-left+1, k)) {
        result = Math.max(result, right-left+1);
      }
      while (!canReach(appears, right-left+1, k)) {
        appears[arr[left]-'A']--;
        left++;
      }
      right++;
    }
    return result;
  }
  private boolean canReach(int[] appears, int size, int k) {
    for (int i = 0; i < 26; i++) {
      if (appears[i]+k >= size) {
        return true;
      }
    }
    return false;
  }
}
