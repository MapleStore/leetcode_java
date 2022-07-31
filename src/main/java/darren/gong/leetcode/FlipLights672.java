package darren.gong.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FlipLights672 {
  public int flipLights(int n, int m) {
    int light = 0xFFFFFFFF;
    n = Math.min(n, 16);
    light = light>>>(32-n);
    int[] map = new int[]{0xFFFFFFFF, 0xAAAAAAAA, 0x55555555, 0x49249249};
    for (int i = 0; i < 4; i++) {
      map[i] = (map[i]<<(32-n))>>>(32-n);
    }

    Set<Integer> set = new HashSet<>();
    set.add(light);
    for (int i = 0; i < 4 && i < m; i++) {
      Set<Integer> next = new HashSet<>();
      for (int j = 0; j < 4; j++) {
        for (int lastLight : set) {
          next.add(lastLight^map[j]);
        }
      }
      set = next;
    }
    return set.size();
  }
}
