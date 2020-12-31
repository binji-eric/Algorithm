/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function(root) {
    if(root == null) {
        return "{}";
    }
    const list = [];
    list.push(root);
    for(let i = 0 ; i < list.length; i++) {
        if(list[i] == null) {
            continue;
        }
        list.push(list[i].left);
        list.push(list[i].right);
    }
    let str = "{";
    str += list[0].val;
    for(let i = 1; i < list.length; i++) {
        str += ",";
        if(list[i] == null) {
            str += "#";
        } else {
            str += list[i].val;
        }
    }
    str += "}";
    return str;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(data) {
    if(data === "{}") {
        return null;
    }
    // the type of arr's element is string
    const arr = data.slice(1, data.length - 1).split(",");
    const root = new TreeNode(Number.parseInt(arr[0]));
    let isLeft = true, index = 0;
    const list = [];
    list.push(root);
    for(let i = 1; i < arr.length; i++) {
        if(arr[i] !== "#") {
            const temp = new TreeNode(Number.parseInt(arr[i]));
            if(isLeft)
                list[index].left = temp;
            else
                list[index].right = temp;
            list.push(temp);
        }
        if(!isLeft) {
            index++;
        }
        isLeft = !isLeft;
    }
    return root;
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */