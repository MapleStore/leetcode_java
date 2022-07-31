package darren.gong.leetcode;

public class CustomStack_1381 {
  private int maxSize;
  private int index = 0;
  private int[] array;
  private int[] add;
  // 1381. 设计一个支持增量操作的栈
  public CustomStack_1381(int maxSize) {
    this.maxSize = maxSize;
    this.array = new int[maxSize];
    this.add = new int[maxSize];
  }

  public void push(int x) {
    if (index >= maxSize) {
      return;
    }
    array[index++] = x;
  }

  public int pop() {
    if (index <= 0) {
      return -1;
    }
    --index;
    int addNum = add[index];
    if (addNum != 0) {
      int addIndex = index-1;
      if (addIndex >= 0) {
        add[addIndex] += addNum;
      }
      add[index] = 0;
    }
    return array[index]+addNum;
  }

  public void increment(int k, int val) {
    int addIndex = Math.min(k-1, index-1);
    if (addIndex < 0) {
      return;
    }
    add[addIndex] += val;
  }
}
