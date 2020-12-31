/**
 * // Definition for a Node.
 * function Node(val, neighbors) {
 *    this.val = val === undefined ? 0 : val;
 *    this.neighbors = neighbors === undefined ? [] : neighbors;
 * };
 */

/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
    if(!node) {
            return node;
        }
    const que = [];
    const map = new Map();
    // HashSet<Node> visited = new HashSet<Node>
    que.push(node);
    map.set(node, new Node(node.val));

    for(let i = 0; i < que.length; i++) {
        const temp = que[i];
        temp.neighbors.forEach((neighbor) => {
            if(!map.has(neighbor)) {
                map.set(neighbor, new Node(neighbor.val));
                que.push(neighbor);
            }
        })
    }

    // connect all nodes
    for(let i = 0; i < que.length; i++) {
        const origin = que[i];
        const copy = map.get(origin);
        origin.neighbors.forEach((neighbor) => {
            copy.neighbors.push(map.get(neighbor));
        });
    }

    return map.get(node);
};