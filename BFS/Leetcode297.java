/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "{}";
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        for(int i = 0; i < list.size(); i++) {
            TreeNode temp = list.get(i);
            if(temp == null) {
                continue;
            }
            // when some nodes are null, they would be added into the list, but their children nodes wouldn't
            list.add(temp.left);
            list.add(temp.right);
        }
        // remove the null value at the tail
        while(list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }
        StringBuilder str = new StringBuilder();
        str.append("{");
        str.append(list.get(0).val);
        // traverse the list again and get the final string
        for(int i = 1; i < list.size(); i++) {
            str.append(",");
            if(list.get(i) == null) {
                str.append("#");
            } else {
                str.append(list.get(i).val);
            }
        }
        str.append("}");
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("{}")) {
            return null;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        String[] arr = data.substring(1, data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        list.add(root);
        boolean isLeft = true;
        int index  = 0;
        for(int i = 1; i < arr.length; i++) {
            if(!arr[i].equals("#")){
                TreeNode temp = new TreeNode(Integer.parseInt(arr[i]));
                if(isLeft) {
                    list.get(index).left = temp;
                } else {
                    list.get(index).right = temp;
                }
                list.add(temp);
            }
            if(!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));