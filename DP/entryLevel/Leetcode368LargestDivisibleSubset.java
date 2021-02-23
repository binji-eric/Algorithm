class Solution {
    // HashMap + LIS
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        // sort from small to large
        Arrays.sort(nums);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int len = nums.length;
        // dp[num] 存储的是 满足num divisble的个数
        int[] dp = new int[len];
        for(int temp: nums) {
            List<Integer> list = new ArrayList<Integer>();
            list.add(temp);
            map.put(temp, list);
        }
        Arrays.fill(dp, 1);
        List<Integer> res = map.get(nums[0]);
        for(int i = 1; i < len; i++) {
            int index = -1, max = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++) {
                if(nums[i]%nums[j] == 0) {
                    // 找到最大的，记录index
                    if(max < dp[j] + 1) {
                        max = dp[j] + 1;
                        index = j;
                    }
                }
            }
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            if(index != -1) {
                dp[i] = max;
                list.addAll(map.get(nums[index]));
                map.put(nums[i], list);
                if(res.size() < list.size()) {
                    res = new ArrayList<Integer>(list);
                }
            } 
        }
        return res;
    }
    
    
    // parent + LIS
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        // sort from small to large
        Arrays.sort(nums);
        int len = nums.length;
        // parent array helps to track the lastest parent
        int[] parent = new int[len];
        Arrays.fill(parent, -1);
        // dp array helps to track number of subset
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
      
        for(int i = 1; i < len; i++) {
            int index = -1, max = Integer.MIN_VALUE;
            for(int j = 0; j < i; j++) {
                if(nums[i]%nums[j] == 0) {
                    if(max < dp[j] + 1) {
                        max = dp[j] + 1;
                        index = j;
                    }
                }
            }
            // 有符合条件的j值
            if(index != -1) {
                dp[i] = max;
                parent[i] = index;
            } 
        }
        
        int totalMax = 1, flag = -1;
        for(int i = 0; i < len; i++) {
            int ele = dp[i];
            if(ele > totalMax) {
                totalMax = ele;
                flag = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        // 返回一个就可以
        if(totalMax == 1) {
            res.add(nums[0]);
        } else {
            while(flag != -1) {
                res.add(nums[flag]);
                flag = parent[flag];
            }
        }
        return res;
    }
}