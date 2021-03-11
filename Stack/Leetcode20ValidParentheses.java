public boolean isValid(String s) {
    char[] arr = s.toCharArray();
    Stack<Character> stack = new Stack<>();
    for(char ele : arr) {
        if(ele == '(' || ele == '{' || ele == '[') {
            stack.push(ele);
        } else {
            if(stack.isEmpty())
                return false;
            char top = stack.pop();
            if(ele == ')' && top == '(')
                continue;
            else if(ele == ']' && top == '[')
                continue;
            else if(ele == '}' && top == '{')
                continue;
            else
                return false;
        }
    }
    
    return stack.isEmpty();
}