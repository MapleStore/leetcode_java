package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicate609 {
  public List<List<String>> findDuplicate(String[] paths) {
    if (paths == null || paths.length == 0) {
      return new ArrayList<>();
    }
    Map<String, List<String>> contentToPaths = new HashMap<>();
    for (String path : paths) {
      String[] pathAndFiles = path.split(" ");
      for (int i = 1; i < pathAndFiles.length; i++) {
        String file = pathAndFiles[i];
        int indexOfLeft = file.indexOf('(');
        int indexOfRight = file.indexOf(')');
        String content = file.substring(indexOfLeft+1, indexOfRight);
        String fileName = file.substring(0, indexOfLeft);
        contentToPaths.putIfAbsent(content, new ArrayList<>());
        contentToPaths.get(content).add(new StringBuilder().append(pathAndFiles[0]).append('/').append(fileName).toString());
      }
    }
    List<List<String>> result = new ArrayList<>();
    for (List<String> oneResult : contentToPaths.values()) {
      if (oneResult.size() <= 1) {
        continue;
      }
      result.add(oneResult);
    }
    return result;
  }
}
