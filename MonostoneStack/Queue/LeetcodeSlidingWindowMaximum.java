public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums == null || k <= 0) {
        return null;
    }
    int len = nums.length;
    int[] res = new int[len-k+1];
    LinkedList<Integer> queue = new LinkedList<Integer>();
    for(int i = 0; i < k-1; i++) {
        while(!queue.isEmpty() && queue.peekLast() < nums[i]) {
            queue.pollLast();
        }
        queue.offerLast(nums[i]);
    }
    
    for(int i = k-1; i < len; i++) {
        while(!queue.isEmpty() && queue.peekLast() < nums[i]) {
            queue.pollLast();
        }
        queue.offerLast(nums[i]);
        res[i-k+1] = queue.peekFirst();
        // 如果滑动窗口的首位 == 最大值，则需要pop
        if(nums[i-k+1] == queue.peekFirst()) {
            queue.pollFirst();
        }
    }
    return res;
}