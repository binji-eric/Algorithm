class myNode {
    public int sum;
    public int num;
    public myNode(int sum, int num) {
        this.sum = sum;
        this.num = num;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    private myNode max  = null;
    private TreeNode target = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        // if(root == null) {
        //     return null;
        // }
        helper(root);
        return target;
    }
    private myNode helper(TreeNode root) {
        if(root == null) {
            return new myNode(0, 0);
        }
        myNode left = helper(root.left);
        myNode right = helper(root.right);
        myNode cur = new myNode(left.sum + right.sum + root.val, left.num + right.num + 1);
        // cur.sum / cur.num > max.sum / max.num
        if(max == null || cur.sum*max.num > cur.num * max.sum) {
            max = cur;
            target = root;
        }
        return cur;
    }
}