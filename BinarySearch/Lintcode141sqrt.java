// Implement int sqrt(int x).

// Compute and return the square root of x.


public int sqrt(int x) {
    // write your code here
    int start = 1, end = x;
    while(start + 1 < end) {
        int mid = start + (end-start)/2;
        if(mid*mid <= x) {
            start = mid;
        } else {
            end = mid;
        }
    }
    if(end*end <= x) {
        return end;
    }
    return start;
}
