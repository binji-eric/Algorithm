class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }
}

private int capacity;
private HashMap<Integer, Node> map = new HashMap<>();
private Node head = new Node(-1, -1), tail = new Node(-1, -1);

/*
* @param capacity: An integer
*/public LRUCache(int capacity) {
    // do intialization if necessary
    this.capacity = capacity;
    this.tail.pre = this.head;
    this.head.next = this.tail;
}

/*
 * @param key: An integer
 * @return: An integer
 */
public int get(int key) {
    // write your code here
    if(!map.containsKey(key)) {
        return -1;
    }
    Node temp = map.get(key);
    // remove temp from the original position
    detachNode(temp);
    // move to the lastest position
    moveToTail(temp);
    return temp.value;
}

/*
 * @param key: An integer
 * @param value: An integer
 * @return: nothing
 */
public void put(int key, int value) {
    // write your code here
    if(get(key) != -1) {
        map.get(key).value = value;
        return;
    }
    // if the current volume equals capacity，从头部删除元素
    if(this.map.size() == this.capacity) {
        this.map.remove(this.head.next.key);
        detachNode(this.head.next);
    }
    Node newNode = new Node(key, value);
    this.map.put(key, newNode);
    moveToTail(newNode);
}

// 新节点放在末尾
public void moveToTail(Node node) {
    // <-
    node.pre = this.tail.pre;
    //     <-
    this.tail.pre = node;
    // ->
    node.pre.next = node;
    //.    ->
    node.next = this.tail;
}

// 删除节点，从头部删除
public void detachNode(Node node) {
    node.pre.next = node.next;
    node.next.pre = node.pre;
}