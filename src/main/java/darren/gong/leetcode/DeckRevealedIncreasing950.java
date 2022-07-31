package darren.gong.leetcode;

import java.util.Arrays;

public class DeckRevealedIncreasing950 {
  public int[] deckRevealedIncreasing(int[] deck) {
    Arrays.sort(deck);
    int length = deck.length;
    int[] result = new int[length];
    int numNeedFill = length;
    int currentIndex = 0;
    int fillIndex = 0;

    boolean fill = true;
    while (numNeedFill > 0) {
      if (result[fillIndex] == 0) {
        if (fill) {
          result[fillIndex] = deck[currentIndex++];
          numNeedFill--;
          fill = false;
        } else {
          fill = true;
        }
      }
      fillIndex = (fillIndex+1)%length;
    }
    return result;
  }
}
