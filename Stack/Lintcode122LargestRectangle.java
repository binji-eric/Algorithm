public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= heights.length; i++) {
            int height = i == heights.length ? -1 : heights[i];
            while(!stack.isEmpty() && height < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : (i - stack.peek() - 1);
                max = Math.max(max, w*h);
            }
            stack.push(i);
        }
        return max;
    }
}