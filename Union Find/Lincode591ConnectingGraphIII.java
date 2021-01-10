private int[] father = null;
private int count;

public ConnectingGraph3(int n) {
    // initialize your data structure here.
    father = new int[n+1];
    count = n;
    for(int i = 1; i <= n; i++) {
        father[i] = i;
    }
}

private int find(int x) {
    if(father[x] == x) {
        return x;
    }
    return father[x] = find(father[x]);
}

public void connect(int a, int b) {
    // write your code here
    int rootA = find(a);
    int rootB = find(b);
    if(rootA != rootB) {
        father[rootA] = rootB;
        count--;
    }
}

/**
 * @return: An integer
 */
public int query() {
    // write your code here
    return count;
}