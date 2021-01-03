class MedianFinder {

    /** initialize your data structure here. */
    private PriorityQueue<Integer> minHeap, maxHeap;
    private int count;
    
    public MedianFinder() {
        // maxHeap 保存小的一半，minHeap保存大的一半
        // maxHeap.size == minHeap.size() || 
        // maxHeap.size == minHeap.size() + 1
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
        count = 0;
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        if(count%2 == 0){
            if(minHeap.isEmpty())
            {
                count++;
                return;
            }
            else if(maxHeap.peek() > minHeap.peek()){
                int maxHeapRoot = maxHeap.poll();
                int minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        }
        else{
            minHeap.add(maxHeap.poll());
        }
        count++;
    }
    
    public double findMedian() {
        if(count%2 == 0)
            return (double)(maxHeap.peek() + minHeap.peek())/2;
        else
            return maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */