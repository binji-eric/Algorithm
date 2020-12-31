/*
// Definition for a Node.
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
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }
        List<Node> que = new ArrayList<Node>();
        HashMap<Node, Node> map = new HashMap<Node, Node>();
        // HashSet<Node> visited = new HashSet<Node>
        que.add(node);
        map.put(node, new Node(node.val));
        
        for(int i = 0; i < que.size(); i++) {
            Node temp = que.get(i);
            for(Node neighbor: temp.neighbors) {
                if(!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    que.add(neighbor);
                }
            }
        }
        
        // connect all nodes
        for(int i = 0; i < que.size(); i++) {
            Node origin = que.get(i);
            Node copy = map.get(origin);
            for(Node neighbor: origin.neighbors) {
                copy.neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
}