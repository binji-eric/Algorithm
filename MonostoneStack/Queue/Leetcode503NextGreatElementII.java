public int[] nextGreaterElements(int[] nums) {
    if(nums == null || nums.length == 0) {
        return nums;
    }
    int len = nums.length;
    int[] res = new int[len];
    LinkedList<Integer> stack = new LinkedList<>();
    Arrays.fill(res, -1);
    // 两遍来解决循环的问题
    for(int i = 0; i < len*2 -1; i++) {
        while(!stack.isEmpty() && nums[stack.peek()%len] < nums[i%len]) {
            res[stack.pop()%len] = nums[i%len];
        }
        stack.push(i);
    }
    return res;
}