public class Solution {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<List<Integer>> res) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        boolean order = true;
        stack1.push(root);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            if(order) {
                while(!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if(node.left != null)
                        stack2.push(node.left);
                    if(node.right != null)
                        stack2.push(node.right);
                }
            } else {
                 while(!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if(node.right != null)
                        stack1.push(node.right);
                    if(node.left != null)
                        stack1.push(node.left);
                }
            }
            res.add(temp);
            order = !order;
        }
        return;
    }
}