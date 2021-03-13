public String addStrings(String num1, String num2) {
        
    // keep the arr1 the longer one
    
    int len1 = num1.length();
    int len2 = num2.length();
    char[] arr1 = num1.toCharArray();
    char[] arr2 = num2.toCharArray();
    // carry 是进位
    int i = len1 - 1, j = len2 -1, carry = 0;
    String res = "";
    while(i >=0 || j >= 0 || carry != 0) {
        int digit1 = i >= 0? arr1[i] - '0': 0;
        int digit2 = j >= 0? arr2[j] - '0': 0;
        int count = digit1 + digit2 + carry;
        res = count%10 + res;
        carry = count/10;
        i--;
        j--;
    }
    return res;
}