// Design and implement a data structure for a Least Frequently Used (LFU) cache.

class LFUCache {
    private class Node{
        int key;
        int value;
        int timer;
        int count;
        public Node(int key, int value, int timer) {
            this.key = key;
            this.value = value;
            this.timer = timer;
            this.count = 1;
        }
    }
    
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private int timer = 0, capacity;
    private PriorityQueue<Node> pq= new PriorityQueue<Node>(new Comparator<Node>(){
        public int compare(Node node1, Node node2) {
            // 访问的次数一致，最早访问的放在前面
            if(node1.count == node2.count) {
                return node1.timer - node2.timer;
            }
            // 次数不一致，访问次数少的放在前面
            return node1.count - node2.count;
        }
    });
    /*
    * @param capacity: An integer
    */public LFUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void put(int key, int value) {
        // write your code here
        this.timer++;
        // 如果设置之前存在过的值，需要修改值
        if(map.containsKey(key)) {
            Node temp = map.get(key);
            pq.remove(temp);
            temp.timer = this.timer;
            temp.count += 1;
            temp.value = value;
            pq.add(temp);
            return;
        }
        // 如果是新值
        // pq满了，我们应该删除队首元素
        if(this.map.size() == this.capacity) {
            // 删除
            Node temp = pq.peek();
            pq.poll();
            if(temp != null) {
                map.remove(temp.key);
            }
        }
        if(this.map.size() < this.capacity) {
            Node temp = new Node(key, value, this.timer);
            pq.add(temp);
            map.put(key, temp);
        }
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        this.timer++;
        if(!map.containsKey(key)) {
            return -1;
        }
        // 如果有该节点
        Node temp = map.get(key);
        pq.remove(temp);
        temp.timer = this.timer;
        temp.count += 1;
        pq.add(temp);
        return temp.value;
    }
}

