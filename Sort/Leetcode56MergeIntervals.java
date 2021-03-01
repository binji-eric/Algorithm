package Sort;

public class Leetcode56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // corn cases
        if(intervals == null || intervals.length == 0) {
            return null;
        }
        
        // array sorts
        Arrays.sort(intervals, new Comparator<int[]>(){
            // sort by the start point
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<int[]> list = new ArrayList<int[]>();
        int len = intervals.length;
        
        // concatenate
        int[] previous = null;
        for(int[] cur : intervals) {
            if(previous == null || cur[0] > previous[1]) {
                previous = cur;
                list.add(cur);
            } else {
                previous[1] = Math.max(previous[1], cur[1]);
            }
        }
        
        // convert arraylist to array
        return list.toArray(new int[list.size()][2]);
    }
}
