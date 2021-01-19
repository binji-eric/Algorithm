// 求出大于等于value的最小值
int find(int[] A, int len, int value) {
    if(A[len-1] < value) {
        return len;
    }
    int l = 0, r = len -1, ans = 0;
    while(l <= r) {
        int mid = (l+r)/2;
        if(A[mid] >= value) {
            ans = mid;
            r = mid - 1;
        } else {
            l = mid +1
        }
    }
    return ans; //返回是index
}


public int subarraySumII(int[] A, int start, int end) {
    int len = A.length;
    int[] sum = new int[len];
    sum[0] = A[0];
    for(int i = 1; i < len; i++) {
        sum[i] = sum[i-1] + A[i];
    }
    // 由于A都是正数，所以sum是单调递增的，下面求出符合条件的范围
    int count = 0;
    for(int i = 0; i < len; i++) {
        if(sum[i] >= start && A[i] <= end) {
            count++;
        }
        int l = A[i] - end;   // 需要求出 >= l的最小值
        int r = A[i] - start; // 需要求出 <= r的最大值
        // 前值的取值范围是 l ~ r
        // find(A, len, r+1)利用r+1求出 >= r+1的最小值，所以他们的差值是
        // find(A, len, r+1) - find(A, len, l)
        count += find(A, len, r+1) - find(A, len, l);
    }
}
