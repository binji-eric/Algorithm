public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null)
        return res;
    boolean flag = false; //true means level order from right to left
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);
    while(!stack1.isEmpty() || !stack2.isEmpty()) {
        List<Integer> levelList = new ArrayList<>();
        if(flag) {
            while(!stack2.isEmpty()) {
                TreeNode temp = stack2.pop();
                levelList.add(temp.val);
                if(temp.right != null)
                    stack1.push(temp.right);
                if(temp.left != null)
                    stack1.push(temp.left);
            }
        } else {
            while(!stack1.isEmpty()) {
                TreeNode temp = stack1.pop();
                levelList.add(temp.val);
                if(temp.left != null)
                    stack2.push(temp.left);
                if(temp.right != null)
                    stack2.push(temp.right);
            }
        }
        
        // 扭转方向，并且将层序遍历的结果加入到result中
        flag = !flag;
        res.add(levelList);
    }
    return res;
}