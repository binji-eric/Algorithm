public int woodCut(int[] L, int k) {
    // write your code here
    if(L == null || L.length == 0) {
        return 0;
    } 
    int max = L[0];
    for(int ele: L) {
        max = Math.max(ele, max);
    }
    int start = 1, end = max;
    while(start + 1 < end) {
        int mid = start + (end - start)/2;
        if(!valid(L, k, mid)) {
            end = mid - 1;
        } else {
            start = mid;
        }
    }
    if(valid(L, k, end)) {
        return end;
    }
    if(valid(L, k, start)) {
        return start;
    }
    return 0;
}

private boolean valid(int[] L, int k, int cut) {
    int count = 0;
    for(int ele: L) {
        count += ele/cut;
    }
    return count >= k;
}