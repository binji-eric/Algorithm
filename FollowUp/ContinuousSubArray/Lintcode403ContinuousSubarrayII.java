// 这里对于连续数组采用了取反的做法
public class Solution {
    /*
     * @param A: An integer array
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> continuousSubarraySumII(int[] A) {
        int n = A.length;
        // totalSum表示数组所有元素之和
        int totalSum = 0;
        // 计算最大连续子数组和
        // maxSum维护全局最大连续子数组和
        // sum维护当前最大连续子数组和，即当前元素必选的最大和
        int maxSum = A[0], sum = 0;
        // first, last表示全局最大连续子数组的左右端点
        // bg表示当前连续子数组的左端点
        int first = 0, last = 0;
        int bg = 0;
        for (int i = 0; i < n; i++) {
            totalSum += A[i];
            if (sum >= 0) {
                sum += A[i];
            }
            else {
                bg = i;
                sum = A[i];
            }
            if (maxSum < sum) {
                maxSum = sum;
                first = bg;
                last = i;
            }
        }
        // 计算最小连续子数组和
        // minSum维护全局最小连续子数组和
        // sum维护当前最小连续子数组和，即当前元素必选的最小和
        // bg表示当前连续子数组的左端点
        int minSum = A[0];
        sum = 0;
        bg = 0;
        for (int i = 0; i < n; i++) {
            if (sum <= 0) {
                sum += A[i];
            }
            else {
                bg = i;
                sum = A[i];
            }
            if (minSum > sum) {
                minSum = sum;
                // 如果整个数组和 - 最小连续子数组和 > 计算最大连续子数组和
                // 那么更新最大值，更新左右端点
                if (minSum != totalSum && totalSum - minSum > maxSum) {
                    first = i + 1;
                    last = bg - 1;
                }
            }
        }
        List<Integer> ans = new ArrayList();
        ans.add(first);
        ans.add(last);
        return ans;
    }
}