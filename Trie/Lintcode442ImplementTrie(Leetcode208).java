public class Trie {
    public class TrieNode {
        // do intialization if necessary
        char ch;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        public TrieNode() {
            
        }
        public TrieNode(char ch) {
            this.ch = ch;
        }
    }
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        TrieNode cur = root;
        HashMap<Character, TrieNode> curChildren = root.children;
        char[] wordArr = word.toCharArray();
        for(int i = 0; i < wordArr.length; i++) {
            char temp = wordArr[i];
            if(curChildren.containsKey(temp)) {
                cur = curChildren.get(temp);
            } else {
                cur = new TrieNode(wordArr[i]);
                curChildren.put(temp, cur);
            }
            if(i == wordArr.length - 1) {
                cur.isWord = true;
            }
            curChildren = cur.children;
        }
        
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        TrieNode res = searchPrefixNode(word);
        if(res == null) {
            return false;
        }
        return res.isWord; // isWord说明是完整单词，否则只是前缀
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        TrieNode res = searchPrefixNode(prefix);
        if(res == null) {
            return false;
        }
        return true;
    }
    
    private TrieNode searchPrefixNode(String word) {
        char[] wordArr = word.toCharArray();
        TrieNode cur = root;
        for(int i = 0; i < wordArr.length; i++) {
            char temp = wordArr[i];
            if(cur.children.containsKey(temp)) {
                cur = cur.children.get(temp);
            } else {
                return null;
            }
        }
        return cur;
    }
}