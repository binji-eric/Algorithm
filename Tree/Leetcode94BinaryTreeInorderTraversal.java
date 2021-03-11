public List<Integer> inorderTraversal(TreeNode root) {
    // res = new ArrayList<Integer>();
    // inorder(root);
    // return res;
    List<Integer> res = new ArrayList<Integer>();
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode helper = root;
    while(helper != null || !stack.isEmpty()) {
        if(helper != null) {
            stack.offerLast(helper);
            helper = helper.left;
        } else {
            helper = stack.pollLast();
            res.add(helper.val);
            helper = helper.right;
        }
    }
    return res;
}