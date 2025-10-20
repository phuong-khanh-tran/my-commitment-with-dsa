package Tree;

public class BuildTreePrePost {
    public TreeNode buildTree(int[] preorder, int[] postorder) {
        int[] index = { 0 }; // pointer on preorder
        return construct(preorder, postorder, index, 0, postorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int[] postorder, int[] index, int l, int h) {
        if (index[0] == preorder.length || l > h) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index[0]++]);
        if (l == h)
            return node;

        int i;
        for (i = l; i <= h; i++) {
            if (preorder[index[0]] == postorder[i])
                break;
        }

        node.left = construct(preorder, postorder, index, l, i);
        node.right = construct(preorder, postorder, index, i + 1, h - 1);

        return node;
    }
}
