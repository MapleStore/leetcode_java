package darren.gong.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class AsteroidCollision735 {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> deque = new LinkedList<>();
    for (int asteroid : asteroids) {
      if (asteroid > 0) {
        deque.addLast(asteroid);
        continue;
      }
      int last = -1;
      boolean asteroidDestroy = false;
      while (!asteroidDestroy && !deque.isEmpty() && (last = deque.peekLast()) > 0) {
        if (last >= -asteroid) {
          asteroidDestroy = true;
        }
        if (last <= -asteroid) {
          deque.pollLast();
        }
      }
      if (!asteroidDestroy) {
        deque.addLast(asteroid);
      }
    }
    int length = deque.size();
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = deque.pollFirst();
    }
    return result;
  }
}
