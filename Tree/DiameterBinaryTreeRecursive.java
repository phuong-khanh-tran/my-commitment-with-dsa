package Tree;

public class DiameterBinaryTreeRecursive {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];

    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left, res);
        int right = dfs(node.right, res);

        res[0] = Math.max(res[0], left + right);
        return (1 + Math.max(left, right));
    }
}
