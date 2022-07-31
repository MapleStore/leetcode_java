package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CanCross403 {
  public boolean canCross(int[] stones) {
    int length = stones.length;
    Map<Integer, Set<Integer>> positionToReachStepSet = new HashMap<>();
    for (int i = 0; i < length; i++) {
      positionToReachStepSet.put(stones[i], new HashSet<>());
    }
    positionToReachStepSet.get(0).add(0);
    for (int position : stones) {
      // 通过哪些步数到目前position
      for (int preStep : positionToReachStepSet.get(position)) {
        for (int currentStep = preStep-1; currentStep <= preStep+1; currentStep++) {
          if (position+currentStep == stones[length-1]) {
            return true;
          }
          Set<Integer> nextJumpFrom = positionToReachStepSet.get(position+currentStep);
          if (currentStep > 0 && nextJumpFrom != null) {
            nextJumpFrom.add(currentStep);
          }
        }
      }
    }
    return false;
  }

  private class Node {
    private int position;
    private int preStep;
    private Node(int position, int preStep) {
      this.position = position;
      this.preStep = preStep;
    }
  }
  public boolean canCrossBFS(int[] stones) {
    int length = stones.length;
    Set<Integer> positions = new HashSet<>();
    for (int stone : stones) {
      positions.add(stone);
    }
    Set<String> visited = new HashSet<>(100);
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(0, 0));
    while (!queue.isEmpty()) {
      Node currentStone = queue.poll();
      for (int i = currentStone.preStep - 1; i <= currentStone.preStep + 1; i++) {
        int nextPos = currentStone.position + i;
        if (nextPos == stones[length - 1]) {
          return true;
        }
        String hash = i + "@" + nextPos;
        if (i > 0 && !visited.contains(hash) && positions.contains(nextPos)) {
          queue.add(new Node(nextPos, i));
          visited.add(hash);
        }
      }
    }
    return false;
  }
}
