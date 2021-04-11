var invertTree = function(root) {
    if(root == null) {
        return null;
    }
    // 需要记录其中的一个子树
    const left = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(left);
    return root;
};