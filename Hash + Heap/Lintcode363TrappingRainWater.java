public int trapRainWater(int[] heights) {
    // write your code here
    if(heights == null || heights.length <= 2) {
        return 0;
    }
    int left = 0, right = heights.length - 1;
    int leftHeight = heights[left], rightHeight = heights[right];
    int sum = 0;
    while(left < right) {
        // 木桶效应, 从短板开始
        if(leftHeight < rightHeight) {
            left++;
            // 更低处才积水
            if(heights[left] < leftHeight) {
                sum += leftHeight - heights[left];
            } else {
                leftHeight = heights[left];
            }
        } else {
            right--;
            if(heights[right] < rightHeight) {
                sum += rightHeight - heights[right];
            } else {
                rightHeight = heights[right];
            }
        }
    }
    return sum;
}