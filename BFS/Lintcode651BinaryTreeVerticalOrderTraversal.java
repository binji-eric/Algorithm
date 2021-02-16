// Given a binary tree, return the vertical order traversal of its nodes' values. 
// (ie, from top to bottom, column by column).

// If two nodes are in the same row and column, the order should be from left to right.


public class Solution {
    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> out = new ArrayList<>();
        if(root == null) {
            return out;
        }
        HashMap<Integer, List<Integer>> res = new HashMap<Integer, List<Integer>>();
        HashMap<TreeNode, Integer> project = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        project.put(root, 0);
        int min = 0, max = 0;
        while(!que.isEmpty()) {
            TreeNode temp = que.poll();
            int index = project.get(temp);
            if(!res.containsKey(index)) {
                res.put(index, new ArrayList<Integer>());
            }
            res.get(index).add(temp.val);
            if(temp.left != null) {
                que.offer(temp.left);
                project.put(temp.left, index-1);
                min = Math.min(min, index-1);
            }
            if(temp.right != null) {
                que.offer(temp.right);
                project.put(temp.right, index+1);
                max = Math.max(max, index+1);
            }
        }
        for(int i = min; i <= max; i++) {
            if(res.containsKey(i)) {
                out.add(res.get(i));
            }
        }
        return out;
    }
}