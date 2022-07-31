package darren.gong.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeGame353 {
  private Queue<int[]> queue = new LinkedList<>();
  private int[] head;
  private int foodIndex = 0;
  private int[][] food;
  private int width;
  private int height;
  private int score = 0;
  private Set<String> body = new HashSet<>();
  /** Initialize your data structure here.
   @param width - screen width
   @param height - screen height
   @param food - A list of food positions
   E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
  public SnakeGame353(int width, int height, int[][] food) {
    this.width = width;
    this.height = height;
    this.food = food;
    this.head = new int[]{0, 0};
    queue.add(head);
  }

  /** Moves the snake.
   @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   @return The game's score after the move. Return -1 if game over.
   Game over when snake crosses the screen boundary or bites its body. */
  public int move(String direction) {
    int currentX = head[0];
    int currentY = head[1];
    int[] next = new int[2];
    if (direction.equals("R")) {
      next[0] = currentX;
      next[1] = currentY+1;
    } else if (direction.equals("L")) {
      next[0] = currentX;
      next[1] = currentY-1;
    } else if (direction.equals("U")) {
      next[0] = currentX-1;
      next[1] = currentY;
    } else {
      next[0] = currentX+1;
      next[1] = currentY;
    }
    if (next[0] < 0 || next[0] >= height || next[1] < 0 || next[1] >= width) {
      return -1;
    }
    if (foodIndex < food.length && next[0] == food[foodIndex][0] && next[1] == food[foodIndex][1]) {
      score++;
      foodIndex++;
      queue.add(next);
      body.add(next[0]+"_"+next[1]);
      head = next;
      return score;
    }
    head = next;
    int[] remove = queue.poll();
    body.remove(remove[0]+"_"+remove[1]);
    if (body.contains(next[0]+"_"+next[1])) {
      return -1;
    }
    queue.add(next);
    body.add(next[0]+"_"+next[1]);
    return score;
  }

}
