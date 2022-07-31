package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal987 {
    // [0,2,1,3,null,null,null,4,5,null,7,6,null,10,8,11,9]
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> allMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        allMap.put(0, new LinkedList());
        allMap.get(0).add(root.val);
        root.val = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> tempMap = new TreeMap<>();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                int index = current.val;
                if (current.left != null) {
                    List<Integer> list = tempMap.get(index-1);
                    if (list == null) {
                        list = new LinkedList<>();
                        tempMap.put(index-1, list);
                    }
                    list.add(current.left.val);
                    current.left.val = index-1;
                    queue.add(current.left);
                }
                if (current.right != null) {
                    List<Integer> list = tempMap.get(index+1);
                    if (list == null) {
                        list = new LinkedList<>();
                        tempMap.put(index+1, list);
                    }
                    list.add(current.right.val);
                    current.right.val = index+1;
                    queue.add(current.right);
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : tempMap.entrySet()) {
                Collections.sort(entry.getValue());
                List<Integer> list = allMap.get(entry.getKey());
                if (list == null) {
                    allMap.put(entry.getKey(), entry.getValue());
                } else {
                    list.addAll(entry.getValue());
                }
            }
        }
        return new LinkedList<>(allMap.values());
    }
}
