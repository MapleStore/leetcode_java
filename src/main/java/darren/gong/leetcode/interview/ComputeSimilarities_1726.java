package darren.gong.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ComputeSimilarities_1726 {
  public List<String> computeSimilarities(int[][] docs) {
    int length = docs.length;
    Map<Integer, Integer>[] maps = new Map[length];
    for (int i = 0; i < length; i++) {
      maps[i] = new HashMap<>();
    }
    for (int i = 0; i < length; i++) {
      for (int word : docs[i]) {
        maps[i].put(word, maps[i].getOrDefault(word, 0)+1);
      }
    }
    List<String> result = new LinkedList<>();
    for (int i = 0; i < length; i++) {
      Map<Integer, Integer> doc1 = maps[i];
      int doc1AllCount = 0;
      for (int val : doc1.values()) {
        doc1AllCount += val;
      }
      if (doc1AllCount == 0) {
        continue;
      }
      for (int j = i+1; j < length; j++) {
        Map<Integer, Integer> doc2 = maps[j];
        int sameCount = 0;
        int doc2AllCount = 0;
        for (Map.Entry<Integer, Integer> entry : doc2.entrySet()) {
          sameCount += doc1.getOrDefault(entry.getKey(), 0);
          doc2AllCount += entry.getValue();
        }
        if (doc2AllCount == 0 || sameCount == 0) {
          continue;
        }
        result.add(i+","+j+": " + String.format("%.4f", (double) sameCount/(double) (doc1AllCount+doc2AllCount-sameCount)));
      }
    }
    return result;
  }

  public List<String> computeSimilarities2(int[][] docs) {
    int length = docs.length;
    int[][] sameCount = new int[length][length];
    Map<Integer, List<Integer>> valToDocs = new HashMap<>();
    for (int i = 0; i < length; i++) {
      int[] doc = docs[i];
      for (int word : doc) {
        List<Integer> sameDocs = valToDocs.computeIfAbsent(word, k->new LinkedList<>());
        for (int sameDoc : sameDocs) {
          sameCount[sameDoc][i]++;
        }
        sameDocs.add(i);
      }
    }
    List<String> result = new LinkedList<>();
    String[] append = new String[]{"","","0000","000","00","0",""};
    for (int i = 0; i < length; i++) {
      for (int j = i+1; j < length; j++) {
        if (sameCount[i][j] != 0) {
          int val = (int) (((double) sameCount[i][j]/(double) (docs[i].length+docs[j].length-sameCount[i][j]))*100000);
          if (val%10 >= 5) {
            val = val/10+1;
          } else {
            val = val/10;
          }
          String end = ""+(double)val/10000;
          result.add(i+","+j+": "+end+append[end.length()]);
        }
      }
    }
    return result;
  }

}
