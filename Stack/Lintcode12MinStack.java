// 利用额外的栈保存有效信息

public class MinStack {
    private LinkedList<Integer> stack, minStack;
    public MinStack() {
        // do intialization if necessary
        stack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if(minStack.size() == 0 || minStack.peek() > number) {
            minStack.push(number);
        } else {
            minStack.push(minStack.peek());
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}