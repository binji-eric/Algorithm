// 翻转栈的运用
public class MyQueue {
    LinkedList<Integer> stack1, stack2;
    public MyQueue() {
        // do intialization if necessary
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) { // O(1)
        // write your code here
        stack1.push(element);
    }


    /*
     * @return: An integer
     */
    public int pop() {   // average O(1)
        // write your code here
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {   // average O(1)
        // write your code here
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
}