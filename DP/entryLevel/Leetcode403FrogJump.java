// If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units.
//  The frog can only jump in the forward direction.

class Solution {
    //     public boolean canCross(int[] stones) {
    //         if(stones == null || stones.length <= 1) {
    //             return true;
    //         }
    //         // key is index of stone, value is Collections of steps to this step
    //         HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    //         for(int i = 0; i < stones.length; i++) {
    //             map.put(i, new HashSet<Integer>());
    //         }
    //         map.get(0).add(0);
            
    //         for(int i = 1; i < stones.length; i++) {
    //             for(int j = i/2; j < i; j++) {
    //                 // if j has been jumped to before
    //                 if(map.get(j).size() > 0) {
    //                     HashSet<Integer> temp = map.get(j);
    //                     for(int ele: temp) {
    //                         if(ele - 1 == stones[i] - stones[j]) {
    //                             map.get(i).add(ele-1);
    //                         } else if(ele == stones[i] - stones[j]) {
    //                             map.get(i).add(ele);
    //                         } else if(ele +1 == stones[i] - stones[j]) {
    //                             map.get(i).add(ele+1);
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //         return map.get(stones.length - 1).size() > 0;
    //     }
         public boolean canCross(int[] stones) {
            if(stones == null || stones.length <= 1) {
                return true;
            }
            Map<Integer, HashSet<Integer>> map = new HashMap<>();
            map.put(0, new HashSet<Integer>());
            // 题目中规定第一步是jump = 1，这里输入0，是可以的，应为下文中的三种情况
            // +0， 原地不动; + 1，符合要求; -1， 排除
            map.get(0).add(0);
            int target = stones[stones.length - 1];
            // 存储的set是之前多少步可以到达指定的stones[i]
            for (int i = 1; i < stones.length; i++){
                map.put(stones[i], new HashSet<Integer>());
            }
            for (int i = 0; i < stones.length - 1; i++){
                int stone = stones[i];
                for (int step : map.get(stone)){
                    int reach = step + stone;
                    if (reach == target || reach-1 == target || reach + 1 == target){
                        return true;
                    }
                    
                    // 正常step到达的
                    HashSet<Integer> set = map.get(reach);
                    if (set != null){
                        set.add(step);
                    }
                    // 比正常的step + 1
                    HashSet<Integer> set2 = map.get(reach+1);
                    if (set2 != null){
                        set2.add(step+1);
                    }
                     // 比正常的step - 1
                    if(step - 1 > 0) {
                        HashSet<Integer> set1 = map.get(reach-1);
                        if (set1 != null){
                            set1.add(step -1);
                        }
                    }
                }
            }
            return false;
        }
    }