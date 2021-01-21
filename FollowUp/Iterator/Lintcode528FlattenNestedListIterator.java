/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    // 对于iterator，不能做的事情:使用dfs，预处理， 应该用stack解决这道题
    private Stack<NestedInteger> stack;
    
    private void pushListToStack(List<NestedInteger> list) {
        Stack<NestedInteger> temp = new Stack<NestedInteger>();
        for(NestedInteger ele: list) {
            temp.push(ele);
        }
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }
    
    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        // 初始化stack
        stack = new Stack<>();
        pushListToStack(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        // 输出当前值，并且淘汰当前值
        if(hasNext()) {
            return stack.pop().getInteger();
        } else {
            return null;
        }
        
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        // 检查可行性，并且准备next值
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
            pushListToStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */