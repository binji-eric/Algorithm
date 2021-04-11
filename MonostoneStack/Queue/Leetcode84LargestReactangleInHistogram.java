public int largestRectangleArea(int[] heights) {
    int max = 0;
    if(heights == null || heights.length == 0) {
        return max;
    }
    // 维持一个单调递增序列
    LinkedList<Integer> stack = new LinkedList<Integer>();
    int len = heights.length;
    stack.push(-1);
    for(int i = 0; i < len; i++) {
        // 如果当前的高度小于之前，需要pop出之前的高度计算面积
        while(stack.peek() != -1 && heights[stack.peek()] > heights[i]) {
            int high = heights[stack.pop()];
            // 宽度的范围是stack.peek() + 1 ~ i-1, 所以宽度是i-1 - (stack.peek()+1) + 1
            max = Math.max(max, high*(i-stack.peek()-1));
        }
        stack.push(i);
    }
    // 剩下一个单调递增序列，其中假设最前的index为-1， 最末尾的index为len， 其实两者是不存在的
    while(stack.peek() != -1) {
        max = Math.max(max, heights[stack.pop()]*(len-stack.peek()-1));
    }
    return max;
}