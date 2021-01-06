public boolean isBalanced(TreeNode root) {
    // write your code here
    if(root == null)
        return true;
  
    if(depth(root) != -1)
        return true;
    return false;
}

private int depth(TreeNode root) {
    if(root == null)
        return 0;
    int left = depth(root.left);
    int right = depth(root.right);
    if(left == -1 || right == -1 || Math.abs(left - right) > 1)  {
        return -1;
    }
    return Math.max(left, right) + 1;
}

// method2
class Node {
    public int depth;
    public boolean isBalanced;
    public Node(int depth, boolean isBalanced) {
        this.depth = depth;
        this.isBalanced = isBalanced;
    }
}

public boolean isBalanced(TreeNode root)  {
    return helper(root).isBalanced;
}

private Node helper(TreeNode root) {
    if(root == null) {
        return new Node(0, true);
    }
    Node left = helper(root.left);
    Node right = helper(root.right);
    if(!left.isBalanced || !right.isBalanced || Math.abs(left.depth - right.depth) > 1) {
        return new Node(-1, false);
    }
    return new Node(Math.max(left.depth, right.depth) + 1, true);
}