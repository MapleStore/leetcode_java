package darren.gong.leetcode;

import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Codec428 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        int id = 0;
        int parent = -1;
        sb.append(id).append(',').append(root.val).append(',').append(parent).append(' ');
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                parent++;
                Node current = queue.poll();
                for (Node child : current.children) {
                    id++;
                    sb.append(id).append(',').append(child.val).append(',').append(parent).append(' ');
                    queue.add(child);
                }
            }
        }
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null || data.equals("[]")) {
            return null;
        }
        String[] nodeStrings = data.split(" ");
        Node root = null;
        Map<Integer, Node> idToNode = new HashMap<>();
        for (String nodeString : nodeStrings) {
            String[] oneNode = nodeString.split(",");
            int id = Integer.valueOf(oneNode[0]);
            int val = Integer.valueOf(oneNode[1]);
            int parent = Integer.valueOf(oneNode[2]);
            if (parent == -1) {
                root = new Node(val, new LinkedList<>());
                idToNode.put(id, root);
                continue;
            }
            Node current = new Node(val, new LinkedList<>());
            idToNode.get(parent).children.add(current);
            idToNode.put(id, current);
        }
        return root;
    }
}
