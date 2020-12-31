public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(edges == null || edges.length == 0) {
            return n == 1;
        }
        if(n -1 != edges.length) {
            return false;
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(0);
        visited.add(0);
        // create map for edges
        for(int[] edge : edges) {
            if(!map.containsKey(edge[0])) {
                map.put(edge[0], new HashSet<Integer>());
            }
            map.get(edge[0]).add(edge[1]);
            if(!map.containsKey(edge[1])) {
                 map.put(edge[1], new HashSet<Integer>());
            }
             map.get(edge[1]).add(edge[0]);
        }
        
        while(!que.isEmpty()) {
            int value = que.poll();
            for(int temp : map.get(value)) {
                if(!visited.contains(temp)) {
                    visited.add(temp);
                    que.offer(temp);
                }
            }
        }
        return visited.size() == n;
    }
}