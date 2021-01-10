private int[] father = null;
private int count = 0;

private int find(int index) {
    if(father[index] == index) {
        return index;
    }
    return father[index] = find(father[index]);
}
private void union(int index1, int index2) {
    int father1 = find(index1);
    int father2 = find(index2);
    if(father1 != father2) {
        father[father1] = father2;
        count--;
    }
}
public boolean validTree(int n, int[][] edges) {
    // write your code here
    count = n;
    father = new int[n];
    for(int i = 0; i < n; i++) {
        father[i] = i;
    }
    if(edges == null || edges.length == 0) {
        return n == 1;
    }
    // 判断节点数 = 边数 + 1
    if(n -1 != edges.length) {
        return false;
    }
    // 如果满足上述条件，但是不是树，必定有环，
    // 同时无法从一个节点出发，到达其他所有节点
    for(int[] edge: edges) {
        union(edge[0], edge[1]);
    }
    return count == 1;
}