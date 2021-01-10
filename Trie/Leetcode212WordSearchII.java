class Solution {
    
    class TrieNode{
        String s;
        boolean isString;
        HashMap<Character, TrieNode> subtree;
        public TrieNode(){
            s = "";
            isString = false;
            subtree = new HashMap<Character, TrieNode>();
        }
    };
    
    class TrieTree{
        TrieNode root;
        public TrieTree(TrieNode node){
            root = node;
        }
        
        public void insert(String str){
            TrieNode cur = root;
            for(int i = 0; i<str.length(); i++){
                Character c = str.charAt(i);
                if(!cur.subtree.containsKey(c))
                    cur.subtree.put(c, new TrieNode());
                cur = cur.subtree.get(c);
            }
            cur.isString = true;
            cur.s = str;
        }
        
        public boolean query(String str){
            TrieNode cur = root;
            for(int i = 0; i< str.length(); i++){
                Character c = str.charAt(i);
                if(!cur.subtree.containsKey(c))
                    return false;
                cur = cur.subtree.get(c);
            }
            return cur.isString;
        }
    };
    
    
    
    
    private int[][] dirs = new int[][]{{-1,0}, {1,0},{0,-1},{0,1}};
    public void search(List<String> res, TrieNode node, char[][] board, int x, int y){
        if(node.isString){
            if(!res.contains(node.s))
                res.add(node.s);
        }
        if(x<0 || x >= board.length || y<0 || y>= board[0].length || board[x][y] == '#' || node == null)
            return;
        if(node.subtree.containsKey(board[x][y])){
            for(int i =0; i<dirs.length; i++){
                char now = board[x][y];
                // 防止回到本轮中刚刚遍历的节点
                board[x][y] = '#';
                search(res, node.subtree.get(now), board, x+dirs[i][0], y+dirs[i][1]);
                board[x][y] = now;
            }
        }
    }
    
    
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        TrieTree tree = new TrieTree(new TrieNode());
        // 对比每个word，加入到Trie树中
        for(String word :  words){
            tree.insert(word);
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                search(res, tree.root, board, i, j);
            }
        }
        return res;
    }
}