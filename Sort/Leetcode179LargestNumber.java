package Sort;

public class Leetcode179LargestNumber {
    private class myComparator implements Comparator<String>{
        public int compare(String s1, String s2){
            String first = s1+s2;
            String second = s2+s1;
            return second.compareTo(first);
        }
    }
    
    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for(int i = 0; i<nums.length; i++){
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, new Comparator<String>(){
        public int compare(String s1, String s2){
            String first = s1+s2;
            String second = s2+s1;
            return second.compareTo(first);
        }
    });
        
        if(array[0].equals("0"))
            return "0";
        StringBuilder res = new StringBuilder();
        for(String ele : array)
            res.append(ele);
        
        return res.toString();
        
    }
}
