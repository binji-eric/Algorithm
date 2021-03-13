public List<List<Integer>> pathSum(TreeNode root, int sum){
	List<List<Integer>> result  = new ArrayList<>();
	List<Integer> currentResult  = new ArrayList<>();
	pathSum(root,sum,currentResult,result);
	return result;
}

public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
		List<List<Integer>> result) {

	if (root == null)
		return;
	currentResult.add(root.val);
    
	if (root.left == null && root.right == null && sum == root.val) {
		result.add(new LinkedList(currentResult));
		currentResult.remove(currentResult.size() - 1);
        //don't forget to remove the last integer
        return;
    }
	 
    pathSum(root.left, sum - root.val, currentResult, result);
	pathSum(root.right, sum - root.val, currentResult, result);
	
    // 删除当前list的最后一个元素，回到上层
	currentResult.remove(currentResult.size() - 1);
}