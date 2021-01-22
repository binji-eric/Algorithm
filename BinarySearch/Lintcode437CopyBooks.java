// Given n books and the i-th book has pages[i] pages. 
// There are k persons to copy these books.
// Return the shortest time that the slowest copier spends.

public int copyBooks(int[] pages, int k) {
    // write your code here
    if(pages == null || pages.length == 0) {
        return 0;
    }
    int sum = 0, max = pages[0];
    for(int page : pages) {
        sum += page;
        max = Math.max(max, page);
    }
    
    // 抄书最长的时间是所有书一个人抄，所花也就是sum时间
    // 抄书最短的时间是一个人抄一本书，所花时间是最长的一本书
    int l = max, r = sum;
    while(l < r) {
        int mid = l + (r-l)/2;
        if(check(pages, mid, k)) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }
    return r;
}

private boolean check(int[] pages, int limit, int k) {
    // limit是划分后每个人的能抄的页数
    int sum = 0, left = 0;
    for(int page: pages) {
        if(page > left) {
            // 新增人
            sum++;
            left = limit;
        }
        left -= page;
    }
    // k个人能够抄的页数需要覆盖全部
    return sum <= k;
}