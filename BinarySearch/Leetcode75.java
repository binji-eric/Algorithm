public int findPeak(int[] A) {
    // write your code here
    int start = 1, end = A.length - 2;
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