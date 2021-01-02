class Solution {
    /*
    // method1 quick sort, time complexity is O(n) ~ O(n^2)
    public int findKthLargest(int[] nums, int k) {
        if(k < 0 || k > nums.length) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            // int mid = low + (high - low)/2;
            int pivot = quickSort(nums, low, high);
            if(pivot > k - 1) {
                high = pivot - 1;
            } else if(pivot < k - 1){
                low  = pivot + 1;
            } else {
                return nums[pivot];
            }
        }
        return nums[low];
    }
    
    private int quickSort(int[] nums, int begin, int end) {
        Random random = new Random();
        int pivot = random.nextInt(end-begin+1) + begin;
        swap(nums, pivot, end);
        int index = begin, i = begin;
        for(; i < end; i++) {
            if(nums[i] >= nums[end]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, end);
        return index;
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    */
    // method2 PriorityQueue, time complexity is O(nlogk)
     public int findKthLargest(int[] nums, int k) {
        if(k < 0 || k > nums.length) {
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
         
        for(int i = k; i < nums.length; i++) {
            if(nums[i] > pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
}