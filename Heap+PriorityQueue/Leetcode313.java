class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        pq.offer(Long.valueOf(1));
        set.add(Long.valueOf(1));
        long res = 0;
        for(int i = 0; i < n; i++) {
            res = pq.poll();
            for(int j = 0; j < primes.length; j++) {
                if(!set.contains(primes[j]*res)) {
                    pq.offer(primes[j]*res);
                    set.add(primes[j]*res);
                }
            }
        }
        return (int)res;
    }
}