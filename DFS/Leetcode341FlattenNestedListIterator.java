// Given a nested list of integers, implement an iterator to flatten it.

// Each element is either an integer, or a list -- whose elements may also be integers or other lists.

public class NestedIterator implements Iterator<Integer> {

    private LinkedList<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<NestedInteger>();
        for(int i = nestedList.size()-1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if(top.isInteger()) {
                return true;
            } else {
                stack.pop();
                List<NestedInteger> temp = top.getList();
                for(int i = temp.size()-1; i>=0; i--) {
                    stack.push(temp.get(i));
                }
            }
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */