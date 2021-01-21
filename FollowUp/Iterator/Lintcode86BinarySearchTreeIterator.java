/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */


public class BSTIterator {
    /**
    * @param root: The root of binary tree.
    */
    private Stack<TreeNode> stack;
    private TreeNode cur;
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        stack = new Stack<TreeNode>();
        cur = root;
    }

    /**
     * @return: True if there has next node, or false
     */
     // 将当前节点的左端点都加入到stack中，直到cur = null
    public boolean hasNext() {
        // write your code here
        while( cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        return !stack.isEmpty();
    }

    /**
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
       if(hasNext()) {
           TreeNode res = stack.pop();
           cur = res.right;
           return res;
       }
       return null;
    }
}