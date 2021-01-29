/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

 /**
  * 
    Given an directed graph, a topological order of the graph nodes is defined as follow:
    For each directed edge A -> B in graph, A must before B in the order list.
    The first node in the order can be any node in the graph with no nodes direct to it.
    Find any topological order for the given graph.
*/

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        if(graph == null || graph.size() == 0) {
            return null;
        }
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        // get indegree of graph
        getInDegree(graph, map);

        ArrayList<DirectedGraphNode> startNodes = getStartNodes(map);
        // get topological sort order by bfs
        ArrayList<DirectedGraphNode> order = bfs(startNodes, map);
        return order.size() == graph.size()? order: null;
    }
    
    private void getInDegree(ArrayList<DirectedGraphNode> graph, HashMap<DirectedGraphNode, Integer> map) {
        // initialize map for every node in graph
        for(DirectedGraphNode node: graph) {
            map.put(node, 0);
        }
        for(DirectedGraphNode node: graph) {
            for(DirectedGraphNode neighbor: node.neighbors) {
                map.put(neighbor, map.get(neighbor) + 1);
            }
        }
    }
    
    private ArrayList<DirectedGraphNode> getStartNodes(HashMap<DirectedGraphNode, Integer> map) {
        ArrayList<DirectedGraphNode> startNodes = new ArrayList<>();
        for(DirectedGraphNode temp: map.keySet()) {
            if(map.get(temp) == 0) {
                startNodes.add(temp);
            }
        }
        return startNodes;
    }
    
    private ArrayList<DirectedGraphNode> bfs(ArrayList<DirectedGraphNode> startNodes,
    HashMap<DirectedGraphNode, Integer> map) {
        
        Queue<DirectedGraphNode> que = new LinkedList<DirectedGraphNode>();
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        for(DirectedGraphNode startNode: startNodes) {
            que.offer(startNode);
        }
        while(!que.isEmpty()) {
            DirectedGraphNode temp = que.poll();
            res.add(temp);
            for(DirectedGraphNode neighbor: temp.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0) {
                    que.offer(neighbor);
                }
            }
        }
        return res;
    }
}