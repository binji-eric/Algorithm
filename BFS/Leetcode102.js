
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    const res = [], que = [];
    if(!root){
        return res;
    }
    que.push(root);
    let levelCount = 1;
    while(que.length) {
        levelCount = que.length;
        let levelArr = [];
        while(levelCount > 0) {
            const temp = que.shift();
            levelArr.push(temp.val);
            levelCount--;
            if(temp.left) {
                que.push(temp.left);
            }
            if(temp.right) {
                que.push(temp.right);
            }
        }    
        res.push(levelArr);
    }
    return res;
    
};