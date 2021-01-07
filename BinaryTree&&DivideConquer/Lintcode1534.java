public TreeNode treeToDoublyList(TreeNode root) {
    // Write your code here.
    
    TreeNode head = null, pre = null;
    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode cur = root;
    while(!stack.isEmpty() || cur != null) {
        if(cur != null) {
            stack.offerLast(cur);
            cur = cur.left;
        } else {
            cur = stack.pollLast();
            if(pre == null) {
                head = cur;
                pre = cur;
            } else {
                pre.right = cur;
                cur.left = pre;
                pre = cur;
            }
            cur = cur.right;
        }
    }
    cur = head;
    while(cur.right != null) {
        cur = cur.right;
    }
    cur.right = head;
    head.left = cur;
    return head;
}