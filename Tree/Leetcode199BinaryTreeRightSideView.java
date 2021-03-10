public List<Integer> rightSideView(TreeNode root) {
    if(root == null) return Collections.emptyList();
   
    List<Integer> result = new ArrayList();
    Queue<TreeNode> queue = new LinkedList();
    queue.add(root);
    //int level = 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i=0;i<size;i++){
            TreeNode node = queue.poll();
             // result记录每层最后一个元素
            if(i == size-1) 
                result.add(node.val);
            if(node.left != null) 
                queue.add(node.left);
            if(node.right != null) 
                queue.add(node.right);
        }
    }
    return result;
}
