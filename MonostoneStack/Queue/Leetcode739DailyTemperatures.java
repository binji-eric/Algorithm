public int[] dailyTemperatures(int[] T) {
    if(T == null || T.length == 0) {
        return T;
    }
    int len = T.length;
    int[] res = new int[len];
    // 维持一个单调递减序列
    LinkedList<Integer> stack = new LinkedList<Integer>();
    for(int i = 0; i < len; i++) {
        while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
            res[stack.peek()] = i - stack.pop();
        }
        stack.push(i);
    }
    return res;
}