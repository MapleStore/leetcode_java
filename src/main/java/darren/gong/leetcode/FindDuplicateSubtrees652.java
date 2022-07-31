package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees652 {
    private int uid = 0;
    private Map<String, Integer> serialToTimes = new HashMap<>();
    private Map<String, Integer> serialToUid = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> result = new LinkedList<>();
        lookup(root, result);
        return result;
    }
    private int lookup(TreeNode root, List<TreeNode> result) {
        if (root == null) {
            return 0;
        }
        String serial = root.val+" "+lookup(root.left, result)+" "+lookup(root.right, result);
        serialToTimes.put(serial, serialToTimes.getOrDefault(serial, 0)+1);
        if (serialToTimes.get(serial) >= 2) {
            if (serialToTimes.get(serial) == 2) {
                result.add(root);
            }
            return serialToUid.get(serial);
        }
        serialToUid.put(serial, uid++);
        return uid-1;
    }
}
