public class Vector2D implements Iterator<Integer> {
    
    
    private Stack<List<Integer>> stack1;
    private Stack<Integer> stack2;
    
    private void push2DListToStack(List<List<Integer>> vec2d) {
        Stack<List<Integer>> temp = new Stack<>();
        for(int i = 0; i < vec2d.size(); i++) {
            temp.push(vec2d.get(i));
        }
        while(!temp.isEmpty()) {
            stack1.push(temp.pop());
        }
    }
    
    private void pushListToStack(List<Integer> list) {
        Stack<Integer> temp = new Stack<>();
        for(int i = 0; i < list.size(); i++) {
            temp.push(list.get(i));
        }
        while(!temp.isEmpty()) {
            stack2.push(temp.pop());
        }
    }

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        // stack1中存储的是List<Integer>
        // stack2中存储的是Integer，是刚刚从stack1中获得list解开得到的
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        push2DListToStack(vec2d);
    }

    @Override
    public Integer next() {
        // Write your code here
        if(hasNext()) {
            return stack2.pop();
        } 
        return null;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        // hasNext中承担中stack1和stack2交互的主要逻辑
        while(!stack1.isEmpty() && stack2.isEmpty()) {
            pushListToStack(stack1.pop());
        }
        return !stack2.isEmpty();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */