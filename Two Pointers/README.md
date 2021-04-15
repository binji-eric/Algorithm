### 分类来源：>>> https://zhuanlan.zhihu.com/p/349940945
    1. 背向（两个指针从相同或者相邻的位置出发，背向移动直到其中一根指针到达边界为止
    2. 同向（即两个指针都相同一个方向移动）
    3. 相向（两个指针从两边出发一起向中间移动直到两个指针相遇）

### 背向双指针 （基本上全是回文串的题）
##### Leetcode409 Longest Palindrome
    1. 可以使用HashMap 计数的方法来解
    2. hint: isOdd; res += (map.get(key)/2)*2
##### Leetcode125 Valid Palindrome
    1. 这道题应该是相向双指针，从两端开始直到相遇
    2，hint: alphanumeric数字字母
##### Leetcode5 Longest Palindromic Substring
    1. 背向双指针 + dp
    2. 构建dp时，外循环i从n-2 -> 0, 内循环j从i+1 -> n
    


### 同向双指针 
##### Leetcode 283. Move Zeroes
    1. 一个指针指向当前位置，另外一个指针指向非0的位置

##### Leetcode 26. Remove Duplicate Numbers in Array
    1. 和283类似，直接返回第一个指针的位置

##### Leetcode3 Longest Substring Without Repeating Characters
    1. slow fast双指针, HashSet维持窗口内元素
    2. arr[fast] 不在set中，set.add(arr[fast]),fast++
    3. arr[fast] 在set中, set.remove(arr[slow]), slow++

##### Leetcode76 Minimum Window Substring
    1. 记录target的hashmap和count
    2. 使用fast遍历s，满足条件后移动slow
    3. 注意intValue的问题，https://leetcode.com/problems/minimum-window-substring/discuss/266059/Why-you-failed-the-last-test-case%3A-An-interesting-bug-when-I-used-two-HashMaps-in-Java





### 补充知识 
    1. HashMap遍历的几种方法 https://blog.csdn.net/q5706503/article/details/85122343
    2. 
    
