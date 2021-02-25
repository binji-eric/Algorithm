class Solution {
    public int maxScore(int[] cardPoints, int k) {
        if(cardPoints == null || cardPoints.length < k) {
            return -1;
        }
        int len = cardPoints.length;
        int[] left = new int[k];
        int[] right = new int[k];
        left[0] = cardPoints[0];
        right[0] = cardPoints[len-1];
        for(int i = 1; i < k; i++) {
            // 从左边数k个
            left[i] = left[i-1] + cardPoints[i];
            // 从右边数k个
            right[i] = right[i-1] + cardPoints[len-1-i];
        }
        // 纯左边，或者纯右边
        int max = Math.max(left[k-1], right[k-1]);
        // 左右边都有，则是k种组合
        if(k >=2) {  
            for(int i = 0; i < k-1; i++) {
                max = Math.max(max, left[i] + right[k-2-i]);
            }
        }
        return max;
    }
}