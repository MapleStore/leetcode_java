package darren.gong.leetcode;

import java.util.TreeSet;

public class ExamRoom_855 {
  public static void main(String[] args) {
    ExamRoom_855 examRoom_855 = new ExamRoom_855(8);
    examRoom_855.seat();
    examRoom_855.seat();
    examRoom_855.seat();
    examRoom_855.leave(0);
    examRoom_855.leave(7);
    examRoom_855.seat();
  }
  private int N;
  private TreeSet<int[]> ranges = new TreeSet<>((a,b)->{
    int disA = (a[0] == 0 || a[1] == N-1) ? a[1]-a[0] : ((a[1]-a[0])>>>1);
    int disB = (b[0] == 0 || b[1] == N-1) ? b[1]-b[0] : ((b[1]-b[0])>>>1);
    if (disA == disB) {
      return b[0]-a[0];
    }
    return disA-disB;
  });
  private TreeSet<Integer> peoples = new TreeSet<>();

  public ExamRoom_855(int N) {
    this.N = N;
    ranges.add(new int[]{0, N-1});
  }

  public int seat() {
    int[] range = ranges.pollLast();
    if (range == null) {
      return -1;
    }
    int position;
    if (range[0] == 0) {
      position = 0;
    } else if (range[1] == N-1) {
      position = N-1;
    } else {
      position = range[0]+((range[1]-range[0])>>>1);
    }
    int[] left = new int[]{range[0], position-1};
    int[] right = new int[]{position+1, range[1]};
    if (left[0] <= left[1]) {
      ranges.add(left);
    }
    if (right[0] <= right[1]) {
      ranges.add(right);
    }
    peoples.add(position);
    return position;
  }

  public void leave(int p) {
    Integer left = peoples.lower(p);
    Integer right = peoples.higher(p);
    if (left == null) {
      left = -1;
    }
    if (right == null) {
      right = N;
    }
    ranges.remove(new int[]{left+1, p-1});
    ranges.remove(new int[]{p+1, right-1});
    ranges.add(new int[]{left+1, right-1});
    peoples.remove(p);
  }
}
