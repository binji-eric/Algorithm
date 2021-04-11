var buildTree = function(preorder, inorder) {
    if(preorder == null || inorder == null) {
        return null;
    }
    const map = new Map();
    for(let i = 0; i < inorder.length; i++) {
        map.set(inorder[i], i);
    }
    return helper(0, 0, inorder.length-1, preorder, inorder, map);
};

function helper(preIndex, inStart, inEnd, preorder, inorder, map) {
    if(preIndex > preorder.length || inStart > inEnd) {
        return null;
    }
    const root = new TreeNode(preorder[preIndex]);
    let index = map.get(preorder[preIndex]);
    // for(let i = inStart; i <= inEnd; i++) {
    //     if(inorder[i] === preorder[preIndex]) {
    //         index = i;
    //     }
    // }
    // 中根遍历是inStart... index-1, (index), index+1 ... inEnd
    // 对应的左子树的长度是index-inStart, 右子树的长度是inEnd - index
    
    root.left = helper(preIndex+1, inStart, index-1, preorder, inorder, map);
    root.right = helper(preIndex + index- inStart+1, index+1, inEnd, preorder, inorder,map);
    return root;
}