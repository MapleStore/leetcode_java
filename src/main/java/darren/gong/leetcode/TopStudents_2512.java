package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class TopStudents_2512 {
  public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
    Set<String> positiveSet = new HashSet<>(Arrays.asList(positive_feedback));
    Set<String> negativeSet = new HashSet<>(Arrays.asList(negative_feedback));
    PriorityQueue<int[]> idScore = new PriorityQueue<>((a,b)-> {
      if (a[1] == b[1]) {
        return a[0]-b[0];
      }
      return b[1]-a[1];
    });
    for (int student = 0; student < report.length; student++) {
      int score = 0;
      String[] words = report[student].split(" ");
      for (String word : words) {
        if (positiveSet.contains(word)) {
          score += 3;
        } else if (negativeSet.contains(word)) {
          score--;
        }
      }
      idScore.add(new int[]{student_id[student], score});
    }
    List<Integer> result = new ArrayList<>();
    while (!idScore.isEmpty() && k-- > 0) {
      result.add(idScore.poll()[0]);
    }
    return result;
  }
}
