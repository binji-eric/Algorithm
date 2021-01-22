// There is an integer array which has the following features:

// The numbers in adjacent positions are different.
// A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
// We define a position P is a peak if:

// A[P] > A[P-1] && A[P] > A[P+1]

public int findPeak(int[] A) {
    // write your code here
    int start = 1, end = A.length - 2;
    // 1. A[0] < A[1] && A[n-2] > A[n-1] 所以一定存在一个peek元素。 
    // 2. 二分时，选择大的一边, 则留下的部分仍然满足1 的条件，即最两边的元素都小于相邻的元素。所以仍然必然存在peek。 
    // 3. 二分至区间足够小，长度为3, 则中间元素就是peek。
    while(start + 1 < end) {
        int mid = start + (end - start)/2;
        if(A[mid-1] > A[mid] ) {
            end = mid;
        } else if(A[mid] < A[mid+1]){
            start = mid;
        } else {
            end = mid;
        }
    }
    if(A[start] > A[end]) {
        return start;
    } else {
        return end;
    }
}