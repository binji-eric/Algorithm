// One envelope can fit into another if and only if 
// both the width and height of one envelope is greater than 
// the width and height of the other envelope.

// What is the maximum number of envelopes can you Russian doll? 

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 
               || envelopes[0] == null || envelopes[0].length != 2)
                return 0;
            Arrays.sort(envelopes, new Comparator<int[]>(){
                public int compare(int[] arr1, int[] arr2){
                    if(arr1[0] == arr2[0])
                        // 高度是从大小到小排列，这样做可以避免把等宽的放在最终的序列中
                        return arr2[1] - arr1[1];
                    else
                        return arr1[0] - arr2[0];
               } 
            });
            int dp[] = new int[envelopes.length];
        // 二分法
            // int len = 0;
            // for(int[] envelope : envelopes){
            //     int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            //     if(index < 0)
            //         index = -(index + 1);
            //     dp[index] = envelope[1];
            //     if(index == len)
            //         len++;
            // }
            // return len;
        
        // DP方法
            Arrays.fill(dp, 1);
            for(int i = 1; i < envelopes.length; i++) {
                for(int j = 0; j < i; j++) {
                    if(envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = 1;
            for(int temp: dp) {
                max = Math.max(max, temp);
            }
            return max;
    }
}