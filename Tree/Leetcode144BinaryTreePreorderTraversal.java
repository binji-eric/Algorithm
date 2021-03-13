public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null) {
        return res;
    }
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    stack.push(root);
    while(!stack.isEmpty()) {
        TreeNode temp = stack.pop();
        res.add(temp.val);
        if(temp.right != null) {
            stack.push(temp.right);
        }
        if(temp.left != null) {
            stack.push(temp.left);
        }
    }
    return res;
}