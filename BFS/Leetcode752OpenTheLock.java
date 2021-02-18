// You have a lock in front of you with 4 circular wheels. 
// Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. 
// The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
// Each move consists of turning one wheel one slot.

// The lock initially starts at '0000', a string representing the state of the 4 wheels.

// You are given a list of deadends dead ends, meaning if the lock displays any of these codes, 
// the wheels of the lock will stop turning and you will be unable to open it.

// Given a target representing the value of the wheels that will unlock the lock,
//  return the minimum total number of turns required to open the lock, or -1 if it is impossible.



class Solution {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")) {
            return 0;
        }
    
        Set<String> deadSet = new HashSet<String>();
        Set<String> visited = new HashSet<String>();
        for(String temp: deadends) {
            deadSet.add(temp);
        }
        if(deadSet.contains("0000")) {
            return -1;
        }
        
        LinkedList<String> que = new LinkedList<String>();
        que.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size > 0) {
                String temp = que.poll();
                if(temp.equals(target)) {
                    return step;
                }
                for(String next: getNextString(temp)) {
                    if(visited.contains(next) || deadSet.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    que.offer(next);
                }
                size--;
            }
             step++;
        }
        return -1;
    }
    
    // 获得下一个可能锁密码排列
    private List<String> getNextString(String start) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < start.length(); i++) {
            if(start.charAt(i) == '9') {
                res.add(getNewString(start, i, '0'));
                res.add(getNewString(start, i, '8'));
            } else if(start.charAt(i) == '0') {
                res.add(getNewString(start, i, '1'));
                res.add(getNewString(start, i, '9'));
            }else {
                res.add(getNewString(start, i, (char)(start.charAt(i) + 1)));
                res.add(getNewString(start, i, (char)(start.charAt(i) - 1)));
            }
        }
        return res;
    }

    // string -> char[] -> string
    private String getNewString(String start, int index, char num) {
        char[] arr = start.toCharArray();
        arr[index] = num;
        return new String(arr);
    }
}