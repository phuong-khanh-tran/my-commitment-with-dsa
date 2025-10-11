package Tree;

public class BuildTreeOptimalSolution2 {
    private int preIdx = 0;
    private int inIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit) {
        if (preIdx == preorder.length)
            return null;
        if (inorder[inIdx] == limit) {
            inIdx++;
            return null;
        }

        TreeNode newNode = new TreeNode(preorder[preIdx++]);
        newNode.left = dfs(preorder, inorder, newNode.val);
        newNode.right = dfs(preorder, inorder, limit);

        return newNode;
    }
}
