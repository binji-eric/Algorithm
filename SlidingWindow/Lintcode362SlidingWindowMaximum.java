// Given an array of n integer with duplicate number, 
// and a moving window(size k), move the window at each iteration from the start of the array, 
// find the maximum number inside the window at each moving.

public class Solution {
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    private void inQueue(Deque<Integer> que, int num) {
        // 如果即将入队的num大于que的尾部的值，将尾部出栈，直到
        // deque为空，或者 deque的尾部 >= num
        while(!que.isEmpty() && que.peekLast() < num ) {
            que.pollLast();
        }
        que.offerLast(num);
    }
    private void outQueue(Deque<Integer> que, int num) {
        // 如果que头部的值 等于 num, que出队列，否则略过
        if(que.peekFirst() == num) {
            que.pollFirst();
        }
    }
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        // 做边界检查
        
        // Deque方法
        List<Integer> res = new ArrayList<Integer>();
        LinkedList<Integer> que = new LinkedList<Integer>();
        if(nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        for(int i = 0; i < k-1; i++) {
            inQueue(que, nums[i]);
        }
        // res.add(que.peekFirst()); // 第一次
        for(int i = k-1; i < nums.length; i++) {
            inQueue(que, nums[i]);   // 入队
            res.add(que.peekFirst());  // 得到区间内的最大值
             outQueue(que, nums[i-k+1]); // 出队
        }
        return res;
        
        
        // PriorityQueue方法
        // List<Integer> res = new ArrayList<Integer>();
        //  if(nums == null || nums.length == 0 || k <= 0) {
        //     return res;
        // }
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
        //     new Comparator<Integer>(){
        //         public int compare(Integer a, Integer b) {
        //             return b - a;
        //         }
        //     }
        // );
        // for(int i = 0; i < k; i++){
        //     pq.offer(nums[i]);
        // }
        // res.add(pq.peek());
        // for(int i = k; i < nums.length; i++) {
        //     pq.remove(nums[i-k]);
        //     pq.offer(nums[i]);
        //     res.add(pq.peek());
        // }
        // return res;
    }
}