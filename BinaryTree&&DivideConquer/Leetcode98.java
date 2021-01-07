// method1
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode root,Integer low, Integer high)
    {
        if(root==null)
            return true;
        if(low!=null&&root.val<=low||high!=null&&root.val>=high)
        {
            return false;
        }
        if(helper(root.left,low,root.val)==false)
            return false;
        if(helper(root.right,root.val,high)==false)
            return false;
        return true;
    }
}

// method2
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode cur = root;
        List<Integer> res = new ArrayList<Integer>();
        while(cur != null || !stack.isEmpty()) {
            if(cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            } else {
                cur = stack.pollLast();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        for(int i = 1; i < res.size(); i++) {
            if(res.get(i) <= res.get(i-1)) {
                return false;
            }
        }
        return true;
    }
    
}