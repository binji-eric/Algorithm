// 递归版本
public int maxDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }
     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
 }

// 非递归版本
public int maxDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }
    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    queue.offerLast(root);
    int depth = 0, maxCount = 1, count = 0;
    while(!queue.isEmpty()) {
        TreeNode temp = queue.pollFirst();
        count++;
        if(temp.left != null) {
            queue.offerLast(temp.left);
        }
        if(temp.right != null) {
            queue.offerLast(temp.right);
        }
        if(count == maxCount) {
            maxCount = queue.size();
            count = 0;
            depth++;
        }
    }
    return depth;
}