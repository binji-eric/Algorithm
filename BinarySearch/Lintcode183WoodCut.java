// Given n pieces of wood with length L[i] (integer array).
//  Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
// What is the longest length you can get from the n pieces of wood? 
// Given L & k, return the maximum length of the small piece

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
         // 符合条件，看是否能切的更小，从而满足k的要求
        if(!valid(L, k, mid)) {
            end = mid - 1;
        } else {
            // 符合条件，看是否能切的大一些
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