public int[] medianII(int[] nums) {
    // write your code here
    if(nums == null) {
        return null;
    }
    int[] res = new int[nums.length];
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int index = 0;
    for(int i = 0; i < nums.length; i++) {
        int temp = nums[i];
        maxHeap.offer(temp);
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if(i >= 2 && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(minHeap.poll());
        }
        
        res[index++] = maxHeap.peek();
        
    }
    return res;
    
}