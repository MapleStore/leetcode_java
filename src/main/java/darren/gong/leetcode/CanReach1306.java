package darren.gong.leetcode;

public class CanReach1306 {
  private int length;
  public boolean canReach(int[] arr, int start) {
    if (arr == null || arr.length == 0) {
      return false;
    }
    length = arr.length;
    return canReach(arr, new boolean[length], start);
  }
  public boolean canReach(int[] arr, boolean[] visited, int start) {
    if (arr[start] == 0) {
      return true;
    }
    int left = start-arr[start];
    boolean canReach = false;
    if (left >= 0 && !visited[left]) {
      visited[left] = true;
      canReach |= canReach(arr, visited, left);
    }
    int right = start+arr[start];
    if (right < length && !visited[right]) {
      visited[right] = true;
      canReach |= canReach(arr, visited, right);
    }
    return canReach;
  }
}
