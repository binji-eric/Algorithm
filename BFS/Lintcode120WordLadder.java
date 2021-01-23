// Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, output the length of the sequence.
// Transformation rule such that:

//     Only one letter can be changed at a time
//     Each intermediate word must exist in the dictionary. (Start and end words do not need to appear in the dictionary )



public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    private int min = Integer.MAX_VALUE;
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        // 确保dict中有最终状态
        dict.add(end);
        Set<String> visited = new HashSet<String>();
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(start);
        int step = 1;
        // BFS
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++) {
                String str = queue.poll();
                for(String nextWord: getNextWords(str, dict)) {
                    if(visited.contains(nextWord)) {
                        continue;
                    } 
                    if(nextWord.equals(end)) {
                        return step;
                    }
                    queue.offer(nextWord);
                    visited.add(nextWord);
                }
            }
        }
        return 0;
    }
    
    public String replaceWord(String word, int index, char ch) {
        char[] arr = word.toCharArray();
        arr[index] = ch;
        return new String(arr);
    }
    
    // 时间复杂度是O(25*L*L), L为单词长度
    public List<String> getNextWords(String word, Set<String> dict) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < word.length(); i++) {
            for(char ch = 'a'; ch <= 'z'; ch++) {
                if(word.charAt(i) == ch) {
                    continue;
                } 
                String newWord = replaceWord(word, i, ch);
                if(dict.contains(newWord)) {
                    res.add(newWord);
                }
            }
        }
        return res;
    }
}