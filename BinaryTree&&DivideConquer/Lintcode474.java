// method1 如果能够保证A，B一定存在于树中
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    // write your code here
    if(root == null || root == A|| root == B) {
        return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, A, B);
    TreeNode right = lowestCommonAncestor(root.right, A, B);
    if(left != null && right != null)
        return root;
    return left != null? left: right;
   
}


// method2 
class ResultType {
    public boolean a_exist, b_exist;
    public TreeNode node;
    public ResultType(boolean a, boolean b, TreeNode root) {
        a_exist = a;
        b_exist = b;
        this.node = root;
    }
}

public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
   
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType res = helper(root, A, B);
        if(res.a_exist && res.b_exist) {
            return res.node;
        } else {
            return null;
        }
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null) {
            return new ResultType(false, false, null);
        }
        ResultType left= helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        boolean a_exist = left.a_exist || right.a_exist || root == A;
        boolean b_exist = left.b_exist || right.b_exist || root == B;
        
        if(root == A || root == B) {
            return new ResultType(a_exist, b_exist, root);
            // 所以是从两个孩子来的，一个是左孩子，一个是右孩子, 则当前root是LCA
        } 
        if(left.node != null && right.node != null) {
            return new ResultType(a_exist, b_exist, root);
        }
        if(left.node != null) {
            return new ResultType(a_exist, b_exist, left.node);
        }
        if(right.node != null) {
            return new ResultType(a_exist, b_exist, right.node);
        } 
        
        return new ResultType(a_exist, b_exist, null);
        
    }
}