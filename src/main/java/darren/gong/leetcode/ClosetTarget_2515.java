package darren.gong.leetcode;

public class ClosetTarget_2515 {
  public int closetTarget(String[] words, String target, int startIndex) {
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < startIndex; i++) {
      if (words[i].equals(target)) {
        result = Math.min(result, (i+words.length)-startIndex);
        break;
      }
    }
    for (int i = startIndex; i >= 0; i--) {
      if (words[i].equals(target)) {
        result = Math.min(result, startIndex-i);
        break;
      }
    }
    for (int i = startIndex+1; i < words.length; i++) {
      if (words[i].equals(target)) {
        result = Math.min(result, i - startIndex);
        break;
      }
    }
    for (int i = words.length-1; i > startIndex; i--) {
      if (words[i].equals(target)) {
        result = Math.min(result, startIndex+words.length-i);
        break;
      }
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }
}
