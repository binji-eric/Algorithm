/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// method1: recursion
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE, maxIndex = 0;
        for(int i = start; i <= end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, maxIndex-1);
        root.right = helper(nums, maxIndex+1, end);
        return root;
    }
}


// method2: use monotonouse stack to solve this problem
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        TreeNode[] treeNums = new TreeNode[len+1];
        for(int i = 0; i < len; i++) {
            treeNums[i] = new TreeNode(nums[i]);
        }
        treeNums[len] = new TreeNode(Integer.MAX_VALUE);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i <= len; i++) {
            int nextValue = i < len? nums[i]: Integer.MAX_VALUE;
            while(!stack.isEmpty() && nextValue > nums[stack.peek()]) {
                int curIndex = stack.pop();
                if(stack.isEmpty()) {
                    treeNums[i].left = treeNums[curIndex];
                    continue;
                }
                int pre = stack.peek();
                if(nums[pre] < nextValue) {
                    treeNums[pre].right = treeNums[curIndex];
                } else {
                    treeNums[i].left = treeNums[curIndex];
                }
            }
            stack.push(i);
        }
        return treeNums[len].left;
    }
}