package darren.gong.leetcode;

import java.util.LinkedList;
import java.util.List;

public class FindWords500 {
  public static void main(String[] args) {
    FindWords500 findWords500 = new FindWords500();
    findWords500.findWords(new String[]{"Hello","Alaska","Dad","Peace"});
  }
  public String[] findWords(String[] words) {
    int[] index = new int['z'+1];
    String first = "qwertyuiop";
    String second = "asdfghjkl";
    String third = "zxcvbnm";
    for (int i = 0; i < first.length(); i++) {
      index[first.charAt(i)] = 0;
      index['A'+first.charAt(i)-'a'] = 0;
    }
    for (int i = 0; i < second.length(); i++) {
      index[second.charAt(i)] = 1;
      index['A'+second.charAt(i)-'a'] = 1;
    }
    for (int i = 0; i < third.length(); i++) {
      index[third.charAt(i)] = 2;
      index['A'+third.charAt(i)-'a'] = 2;
    }
    List<String> result = new LinkedList<>();
    for (String word : words) {
      int currentIndex = -1;
      boolean canJoin = true;
      for (char oneChar : word.toCharArray()) {
        if (currentIndex == -1) {
          currentIndex = index[oneChar];
        } else if (currentIndex != index[oneChar]) {
          canJoin = false;
          break;
        }
      }
      if (canJoin) {
        result.add(word);
      }
    }
    String[] realResult = new String[result.size()];
    return result.toArray(realResult);
  }
}
