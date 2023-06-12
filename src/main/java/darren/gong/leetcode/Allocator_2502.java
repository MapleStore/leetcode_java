package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Allocator_2502 {
  public static void main(String[] args) {
    Allocator_2502 allocator_2502 = new Allocator_2502(10);
    allocator_2502.allocate(1,1);
    allocator_2502.allocate(1,2);
    allocator_2502.allocate(1,3);
    allocator_2502.free(2);
  }
  private int[] mem;
  private int n;
  public Allocator_2502(int n) {
    this.mem = new int[n];
    this.n = n;
  }

  public int allocate(int size, int mID) {
    int currentSize = 0;
    for (int i = 0; i < n; i++) {
      if (mem[i] == 0) {
        currentSize++;
      } else {
        currentSize = 0;
      }
      if (currentSize >= size) {
        Arrays.fill(mem, i-size+1, i+1, mID);
        return i-size+1;
      }
    }
    return -1;
  }

  public int free(int mID) {
    int size = 0;
    for (int i = 0; i < n; i++) {
      if (mem[i] == mID) {
        mem[i] = 0;
        size++;
      }
    }
    return size;
  }
}
