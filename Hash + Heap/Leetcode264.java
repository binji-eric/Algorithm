class Solution {
    
        // pq method
        public int nthUglyNumber(int n) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            long[] choices = {2L, 3L, 5L};
            HashSet<Long> set = new HashSet<>();
            pq.offer(Long.valueOf(1));
            set.add(Long.valueOf(1));
            long res = 0;
            for(int i = 0; i < n; i++) {
                res = pq.poll();
                for(int j = 0; j < choices.length; j++) {
                    if(!set.contains(choices[j]*res)) {
                        pq.offer(choices[j]*res);
                        set.add(choices[j]*res);
                    }
                }
            }
            return (int)res;
        }
    
        // index 
        public int nthUglyNumber(int n) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(1);
            int index2 = 0, index3 = 0, index5 = 0;
            
            for(int i = 1; i < n; i++) {
                int lastValue = res.get(res.size() - 1);
                while(res.get(index2)*2 <= lastValue) {
                    index2++;
                }
                while(res.get(index3)*3 <= lastValue) {
                    index3++;
                } 
                while(res.get(index5)*5 <= lastValue) {
                    index5++;
                }
                res.add(Math.min(
                            Math.min(res.get(index2)*2, res.get(index3)*3), 
                                 res.get(index5)*5)
                       );
            }
            return res.get(res.size()-1);
        }
    }