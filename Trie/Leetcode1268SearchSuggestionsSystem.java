class Trie {
    Trie[] children;  // 每个Trie node需要有26个孩子节点
    List<String> words;
    public Trie() {
        children = new Trie[26];
        words = new ArrayList<String>();
    }
}

public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Arrays.sort(products);
    // 构造Trie树
    Trie root = new Trie();
    for(String str: products) {
        char[] children = str.toCharArray();
        Trie cur = root;
        for(int i = 0; i < children.length; i++) {
            if(cur.children[children[i]  - 'a'] == null) {
                cur.children[children[i] - 'a'] = new Trie();
            }
            cur = cur.children[children[i] - 'a'];
            if(cur.words.size() < 3) {
                cur.words.add(str);
            }
        }
    }
    
    List<List<String>> res = new ArrayList<>();
    // 模拟search的过程
    char[] searchArr = searchWord.toCharArray();
    Trie cur = root;
    for(int i = 0; i < searchArr.length; i++) {
        char tmp = searchArr[i];
        if(cur.children[tmp - 'a'] == null) {
            break;
        } else {
            cur = cur.children[tmp - 'a'];
            res.add(cur.words);
        }
    }
    while(res.size() < searchWord.length()) {
        res.add(new ArrayList<String>());
    }
    return res;
}