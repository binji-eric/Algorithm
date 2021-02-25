class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for(int i = 1; i < A.length; i++) {
            A[i] += A[i-1];
        }
        int maxL = A[L-1], maxM = A[M-1], max = A[L+M-1];
        for(int i = L + M; i < A.length; i++) {
            // L在左侧，M 在右侧
            maxL = Math.max(maxL, A[i-M]-A[i-M-L]);
            // M在左侧， L在右侧
            maxM = Math.max(maxM, A[i-L]-A[i-M-L]);
            max = Math.max(max, Math.max(maxL + A[i] - A[i-M], maxM + A[i] - A[i-L]));
        }
        return max;
    }
}s