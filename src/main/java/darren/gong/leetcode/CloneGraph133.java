package darren.gong.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        cloneNeighbors(newNode, node, map);
        return newNode;
    }
    private void cloneNeighbors(Node sourceNode, Node targetNeighbor, Map<Integer, Node> map) {
        if (sourceNode == null || targetNeighbor == null) {
            return;
        }
        for (Node neighbor : targetNeighbor.neighbors) {
            if (map.containsKey(neighbor.val)) {
                sourceNode.neighbors.add(map.get(neighbor.val));
            } else {
                Node addNeighbor = new Node(neighbor.val);
                map.put(neighbor.val, addNeighbor);
                sourceNode.neighbors.add(addNeighbor);
                cloneNeighbors(addNeighbor, neighbor, map);
            }
        }
        return;
    }
}
