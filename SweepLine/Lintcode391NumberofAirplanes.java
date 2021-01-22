// Given an list interval, which are taking off and landing time of the flight. 
// How many airplanes are there at most at the same time in the sky?


/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Point {
    int time, flag;
    // for flag, landing is 0, take off is 1
    public Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
    public static Comparator<Point> PointComparator = new Comparator<Point>(){
        public int compare(Point a, Point b) {
            if(a.time == b.time) {
                return a.flag - b.flag;
            }
            return a.time - b.time;
        }
    };
 }
 
 public class Solution {
     /**
      * @param airplanes: An interval array
      * @return: Count of airplanes are in the sky.
      */
     public int countOfAirplanes(List<Interval> airplanes) {
        List<Point> list = new ArrayList<>();
        for(Interval airplane: airplanes) {
            list.add(new Point(airplane.start, 1));
            list.add(new Point(airplane.end, 0));
        }
        Collections.sort(list, Point.PointComparator);
        int max = 0, count = 0;
        for(int i = 0; i < list.size(); i++) {
            Point temp = list.get(i);
            if(temp.flag == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
         return max;
         // write your code here
         // int len = airplanes.size(), i = 0;
         // int[] f = new int[len], l = new int[len];
         // for(Interval airplane : airplanes) {
         //     f[i] = airplane.start;
         //     l[i] = airplane.end;
         //     i++;
         // }
         // Arrays.sort(f);
         // Arrays.sort(l);
         // int max = 0, num = 0, j = 0;
         // i = 0;
         // for(; i < len;) {
         //     if(f[i] < l[j]) {
         //         num++;
         //         max = Math.max(num, max);
         //         i++;
         //     } else {
         //         num--;
         //         j++;
         //     }
         // }
         // return max;
     }
 }