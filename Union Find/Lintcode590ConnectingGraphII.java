public class {
    private int[] father = null;
    private int[] size = null;

    private int find(int x) {
        if(father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }

    private void connect(int a, int b) {
        int father_a = find(a);
        int father_b = find(b);
        if(father_a != father_b) {
            father[father_a] = father_b;
            size[father_b] += size[father_a];
        } 
    }

    public ConnectingGraph2(int n) {
        father = new int[n+1];
        for(int i = 1; i <= n; i++) {
            father[i] = 1;
            size[i] = 1;
        }
    }

    public int query(int a) {
        int father_a = find(a);
        return size[father_a];
    }
}