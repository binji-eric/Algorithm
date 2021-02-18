public String decodeString(String s) {
    Stack<Integer> count = new Stack<>();
    Stack<String> result = new Stack<>();
    int i = 0;
    result.push("");
    while (i < s.length()) {
        char ch = s.charAt(i);
        // 如果是数字
        if (Character.isDigit(ch)) {
            int start = i;
            // 下个也是数字的话，一直计算
            while (Character.isDigit(s.charAt(i+1))) i++;
            count.push(Integer.parseInt(s.substring(start, i + 1)));
        } else if (ch == '[') {
            result.push("");
        } else if (ch == ']') {
            String str = result.pop();
            StringBuilder sb = new StringBuilder();
            int times = count.pop();
            for (int j = 0; j < times; j += 1) {
                sb.append(str);
            }
            // 注入扩展后的内容
            result.push(result.pop() + sb.toString());
        } else {
            // 如果是字符，进行拼接
            result.push(result.pop() + ch);
        }
        i++;
    }
    return result.pop();
}