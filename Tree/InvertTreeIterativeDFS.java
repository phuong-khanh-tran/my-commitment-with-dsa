package Tree;

import java.util.Stack;

public class InvertTreeIterativeDFS {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            TreeNode temp = top.left;
            top.left = top.right;
            top.right = temp;

            if (top.left != null) {
                stack.push(top.left);
            }

            if (top.right != null) {
                stack.push(top.right);
            }
        }

        return root;
    }
}
