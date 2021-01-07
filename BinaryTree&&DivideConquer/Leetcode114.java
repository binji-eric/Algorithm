class Solution {
    // method1 iteration迭代的方法
    public void flatten(TreeNode root) {
        // pre-order traverse
        if(root == null) {
            return;
        }
        TreeNode pre = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pollFirst();
            if(temp.right != null) {
                stack.offerFirst(temp.right);
            }
            if(temp.left != null) {
                stack.offerFirst(temp.left);
            }
            temp.left = null;
            if(pre != null)
                pre.right = temp;
            pre = temp;
        }
    }
    
    // method2, recursion 递归的方法
    TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        // because root would modify its right children in the flatten(root.left)
        // so we need to save the right node of root
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
    
     // method3 分冶的方法
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    // this will return the last node of root
    public TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        // connect node according to pre-order sequence
        if(leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if(rightLast != null) {
            return rightLast;
        }
        if(leftLast != null) {
            return leftLast;
        }
        return root;
    }
    
}