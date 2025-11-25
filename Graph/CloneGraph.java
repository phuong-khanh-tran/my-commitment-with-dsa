package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
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

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Node, Node> oriToCopy = new HashMap<>();
        return dfs(node, oriToCopy);
    }

    private Node dfs(Node node, Map<Node, Node> oriToCopy) {
        if (node != null && !oriToCopy.containsKey(node)) {
            oriToCopy.put(node, new Node(node.val));
            Node copy = oriToCopy.get(node);
            for (Node n : node.neighbors) {
                copy.neighbors.add(dfs(n, oriToCopy));
            }
        }
        return oriToCopy.get(node);
    }
}
