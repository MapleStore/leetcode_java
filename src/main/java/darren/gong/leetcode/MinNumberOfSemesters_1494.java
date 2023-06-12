package darren.gong.leetcode;

import java.util.Arrays;

public class MinNumberOfSemesters_1494 {
  public static void main(String[] args) {
    MinNumberOfSemesters_1494 minNumberOfSemesters_1494 = new MinNumberOfSemesters_1494();
    minNumberOfSemesters_1494.minNumberOfSemesters(11, new int[][]{}, 2);
  }
  public int minNumberOfSemesters(int n, int[][] relations, int k) {
    int[] courseNeed = new int[n+1];
    for (int[] relation : relations) {
      courseNeed[relation[1]-1] |= (1<<relation[0]-1);
    }
    int[] coursesNeed = new int[1<<n];
    for (int courses = 1; courses < (1<<n); courses++) {
      if (Integer.bitCount(courses) > k) {
        coursesNeed[courses] |= courses;
        continue;
      }
      for (int i = 0; i < n; i++) {
        if (((1<<i)&courses) != 0) {
          coursesNeed[courses] |= courseNeed[i];
        }
      }
    }
    int[] dp = new int[1<<n];
    Arrays.fill(dp, 1000);
    dp[0] = 0;
    for (int courses = 1; courses < 1<<n; courses++) {
      for (int subCourses = courses; subCourses > 0; subCourses = courses&(subCourses-1)) {
        if ((coursesNeed[subCourses]&subCourses) == 0 && (courses&coursesNeed[subCourses]) == coursesNeed[subCourses]) {
          dp[courses] = Math.min(dp[courses], dp[courses^subCourses]+1);
        }
      }
    }
    return dp[(1<<n)-1];
  }
}