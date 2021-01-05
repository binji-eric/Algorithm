public void rerange(int[] A) {
    // write your code here]
    // 先排序，负数在前，正数在后
     if(A == null || A.length == 0) {
        return;
    }
    int left = 0, right = A.length - 1;
    while(left < right) {
        while(left < right && A[left] < 0) {
            left++;
        }
        while(left < right && A[right] >= 0) {
            right--;
        }
        if(left < right) {
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
            left++;
            right--;
        }
    }
    // 根据不同情况进行交叉
    if(A[left] < 0) {
        left = left + 1;
    }
    // 进行交叉
    // 如果负数多
    if(left > A.length - left){         
        interleave(A,1,A.length - 1);
    // 如果正数多
    }else if(left < A.length - left){
        interleave(A,0,A.length - 2);
    }
    // 相等
    else{
        interleave(A,0,A.length - 1);
    }
    
}

public void interleave(int[] A, int start, int end){   
    while(start <= end){
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
        start += 2;
        end -= 2;
    }
}