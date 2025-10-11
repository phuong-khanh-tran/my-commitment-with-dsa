package Tree;

public class kthSmallest {
    public int getKthSmallest(TreeNode root, int k) {
        int[] kth = new int[] { k };
        return dfs(root, kth);
    }

    private int dfs(TreeNode root, int[] kth) {
        if (root == null) {
            return -1;
        }

        int minLeft = dfs(root.left, kth);
        if (minLeft != -1)
            return minLeft;

        kth[0]--;
        if (kth[0] == 0) {
            return root.val;
        }

        int minRight = dfs(root.right, kth);
        if (minRight != -1)
            return minRight;

        return -1;
    }
}
