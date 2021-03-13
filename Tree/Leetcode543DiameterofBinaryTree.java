public int diameterOfBinaryTree(TreeNode root) {
    if(root == null)
        return 0;
     int cur = height(root.left) + height(root.right);
     int left = diameterOfBinaryTree(root.left);
     int right = diameterOfBinaryTree(root.right);
     return Math.max(cur, Math.max(left, right));
 }
 
 public int height(TreeNode root){
     if(root == null)
         return 0;
     return 1+ Math.max(height(root.left), height(root.right));
 }