### Leetcode208 Implement Trie
    1. Trie Node(char ch, HashMap children, boolean isWord)
    2. basic methods: insert, search, startsWith, searchPrefixNode

### Leetcode79 Word Search (DFS + backtracking)
    1. time complexity is O(M*N*L) L is the length of word

### Leetcode212 Word SearchII (Trie + BFS/DFS + backtracking)
    1. construct the Trie Tree and corresponding methods
    2. for each word in words array, add them into Trie Tree
    3. for each node in the board, search them in the Trie Tree
    4. the left part is similar to the Leetcode79 Word Search

### Leetcode211 Design Add and Search Words Data Structure
    1. construct the Trie Tree and addWord
    2. in the searchHelper(word, index, TrieNode root), if(word[index] == '.') search all the children of root, else search specific child of root


### Leetcode1268 Search Suggestions System
    1. time complexity is O(M), M 是products中所有字符的数量
    2. space complexity si O(26n) = O(n), n是Trie node的数量