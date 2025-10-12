package Tree;

import java.util.Arrays;
import java.util.List;

public class SerializeAndDeserialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> ls = Arrays.asList(data.split(","));
        int[] index = new int[] { 0 };

        return dfs(ls, index);
    }

    private TreeNode dfs(List<String> ls, int[] index) {
        String curr = ls.get(index[0]);

        index[0]++;
        if (curr.equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(curr));
        root.left = dfs(ls, index);
        root.right = dfs(ls, index);

        return root;
    }
}
