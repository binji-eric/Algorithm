    public int[] parent;
    public int size = 0;
    
    public int find(int node){
        if(parent[node] == node)
            return node;
        parent[node] = find(parent[node]);
        return parent[node];
    }
     
    public void union(int node1, int node2){
        int find1 = find(node1);
        int find2 = find(node2);
        // 产生的连接，则岛屿的个数减少
        if(find1 != find2){
            parent[find1] = find2;
            size--;
        }
    }
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(operators == null || operators.length == 0)
            return res;
        parent = new int[n*m];
        int[][] graph = new int[n][m];
        for(int i = 0; i<n*m; i++){
            parent[i] = i;
        }
        int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};
        for(int i = 0; i<operators.length; i++){
            int x = operators[i].x;
            int y = operators[i].y;
            // 如果已经是1，可以直接跳过
            if(graph[x][y] == 1){
                res.add(size);
                continue;
            }
            graph[x][y] = 1;
            size++;
            // 对于xy的上下左右四个节点调查
            // 加入新节点后，进行新的连接，并且求出新的size
            for(int[] dir : dirs){
                int x1 = x + dir[0];
                int y1 = y + dir[1];
                if(x1>=0 && x1<n && y1>=0 && y1<m && graph[x1][y1] ==1){
                    union(x*m+y,  x1*m+y1);
                }
            }
            res.add(size);
        }
        return res;
    
    }