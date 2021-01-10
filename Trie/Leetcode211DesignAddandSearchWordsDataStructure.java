class TrieNode{
    public boolean hasWord;
    public TrieNode[] children;
    public TrieNode(){
        this.children = new TrieNode[26];
        for(int i = 0; i <26; i++) {
            this.children[i] = null;
        }
        this.hasWord = false;
    }
}


class WordDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode now = root;
        char[] wordArr = word.toCharArray();
        for(int i = 0; i < wordArr.length; i++) {
            char temp = wordArr[i];
            if(now.children[temp-'a'] == null) {
                now.children[temp-'a'] = new TrieNode();
            }
            now = now.children[temp-'a'];
        }
        now.hasWord = true;
    }
    
    
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    private boolean searchHelper(String word, int index, TrieNode root) {
        if(index == word.length()) {
            return root.hasWord;
        }
        char ch = word.charAt(index);
        if(ch == '.') {
            for(int i = 0; i < 26; i++) {
                if(root.children[i] != null) {
                    if(searchHelper(word, index+1, root.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        } else if(root.children[ch-'a'] != null){
            return searchHelper(word, index+1, root.children[ch-'a']);
        } else {
            return false;
        }
    }
        
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */