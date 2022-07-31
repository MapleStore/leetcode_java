package darren.gong.leetcode;

import java.util.Arrays;

public class VideoStitching_1024 {
  // 1024. 视频拼接
  public int videoStitching(int[][] clips, int T) {
    if (T == 0) {
      return 0;
    }
    Arrays.sort(clips, (a,b)->a[0]-b[0]);
    int end = 0;
    int nextEnd = 0;
    int result = 0;
    for (int[] clip : clips) {
      if (clip[0] > nextEnd) {
        return -1;
      }
      if (clip[0] > end) {
        end = nextEnd;
        result++;
      }
      nextEnd = Math.max(nextEnd, clip[1]);
      if (nextEnd >= T) {
        return result+1;
      }
    }
    return -1;
  }
}
