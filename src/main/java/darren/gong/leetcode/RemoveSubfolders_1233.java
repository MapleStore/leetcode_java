package darren.gong.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RemoveSubfolders_1233 {
  // 1233. 删除子文件夹
  public static void main(String[] args) {
    RemoveSubfolders_1233 removeSubfolders_1233 = new RemoveSubfolders_1233();
    removeSubfolders_1233.removeSubfolders(new String[]{"/a/","/a/b","/c/d/","/c/d/g","/c/f/"});
  }
  public List<String> removeSubfolders(String[] folder) {
    Arrays.sort(folder, (a,b)->a.length()-b.length());
    Set<String> set = new HashSet<>();
    for (String oneFolder : folder) {
      String[] paths = oneFolder.split("/");
      StringBuilder sb = new StringBuilder();
      boolean shouldAdd = true;
      int size = paths.length;
      for (int i = 1; i < size; i++) {
        sb.append("/");
        sb.append(paths[i]);
        if (set.contains(sb.toString())) {
          shouldAdd = false;
          break;
        }
      }
      if (shouldAdd) {
        set.add(oneFolder);
      }
    }
    return new LinkedList<>(set);
  }
}
