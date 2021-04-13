public int[] parent;
public int total;
public int find(int i) {
    if(parent[i] == i) {
        return i;
    }
    parent[i] = find(parent[i]);
    return parent[i];
}
public void union(int num1, int num2) {
    int parent1 = find(num1);
    int parent2 = find(num2);
    if(parent1 != parent2) {
        parent[parent1] = parent2;
        total--;
    }
    return;
}
public int findCircleNum(int[][] isConnected) {
    int n = isConnected.length;
    total = n;
    parent = new int[n];
    for(int i = 0; i < n; i++) {
        parent[i] = i;
    }
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            if(isConnected[i][j] == 1) {
                union(i, j);
            }
        }
    }
    return total;
}