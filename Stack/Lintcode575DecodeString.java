public class Solution {
    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        char[] sArr = s.toCharArray();
        Stack<Object> stack = new Stack<Object>();
        int number = 0;
        for(char ch: sArr) {
            if(Character.isDigit(ch)) {
                number = number*10 + ch - '0';
                // 开始时，将之前汇总的数字加一块
            } else if(ch == '[') {
                stack.push(Integer.valueOf(number));
                number = 0;
            } else if(ch == ']') {
                // 遇到]，说明开始处理前面的字符
                String newStr = popStack(stack);
                Integer count = (Integer)stack.pop();
                // 按照number，重复指定的string, 再次放入stack
                for(int i = 0; i < count; i++) {
                    stack.push(newStr);
                }
            } else {
                stack.push(String.valueOf(ch));
            }
        }
        return popStack(stack);
    }
    
    private String popStack(Stack<Object> stack) {
        // 利用辅助栈，颠倒顺序
        Stack<String> buffer = new Stack<String>();
        while(!stack.isEmpty() && stack.peek() instanceof String) {
            buffer.push((String)stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }
}