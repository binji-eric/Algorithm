class StockSpanner {
    
    LinkedList<int[]> stack; // stack中为递减序列

    public StockSpanner() {
        stack = new LinkedList<>();
    }
    
    public int next(int price) {
       int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */