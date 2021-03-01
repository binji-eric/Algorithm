package Sort;

public class Leetcode4MedianofTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length=nums1.length+nums2.length;
        double outcome=0;
        outcome=(findMedian(nums1,nums2,0,nums1.length,0,nums2.length,(length+1)/2)+findMedian(nums1,nums2,0,nums1.length,0,nums2.length,length/2+1))/2.0;
        return outcome;
        
    }
    
    public double findMedian(int[] nums1,int[] nums2, int begin1, int length1,int begin2, int length2, int target)
    {
        // 保证nums1是最小的
        if(length1>length2) {
            return findMedian(nums2,nums1,begin2,length2,begin1,length1,target);
        }
        if(length1==0) {
            return nums2[begin2+target-1];
        }
        if(target==1) {
            return Math.min(nums1[begin1],nums2[begin2]);
        }
        int p=Math.min(length1,target/2);
        int q=target-p;
        if(nums1[begin1+p-1]==nums2[begin2+q-1])
            return nums1[begin1+p-1];
        // 将target的范围在nums2上缩小q
        else if(nums1[begin1+p-1]>nums2[begin2+q-1])
            return findMedian(nums1,nums2,begin1,length1,begin2+q,length2-q,target-q);
         // 将target的范围在nums1上缩小p
        else 
             return findMedian(nums1,nums2,begin1+p,length1-p,begin2,length2,target-p);
       
    }
}
