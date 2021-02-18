class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
        if(routes == null || routes.length == 0 || routes[0] == null) {
            return -1;
        }
        // map中存储着指定车站，由哪些车会经过 bus station -> {bus1, bus2, bus3}
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                // i represents order of buses, rotues[i][j] is the bus stop
                if(!map.containsKey(routes[i][j])) {
                    map.put(routes[i][j], new ArrayList<Integer>());
                }
                map.get(routes[i][j]).add(i);
            }
        }
         // set stores the bus has been taken before
        HashSet<Integer> busVisited = new HashSet<>();
        if(!map.containsKey(source)) {
            return -1;
        }
        // que stores the bus Stations
        LinkedList<Integer> que = new LinkedList<>();
        int step = 0;
        que.offer(source);
        while(!que.isEmpty()) {
            int size = que.size();
            // size为同一step下，车站的选择性
            while(size> 0) {
                int busStation = que.poll();
                // find the target, return
                if(busStation == target) {
                    return step;
                }
                // get next bus
                if(map.containsKey(busStation)) {
                    for(int busIndex: map.get(busStation)) {
                        if(!busVisited.contains(busIndex)) {
                            for(int station: routes[busIndex]) {
                                que.offer(station);
                            }
                            busVisited.add(busIndex);
                        }
                    }
                }
                size--;
            }
            step++;
        }
        return -1;
    }
}