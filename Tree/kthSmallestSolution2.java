package Tree;

import java.util.Stack;

public class kthSmallestSolution2 {
    public int kthSmall(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            k--;
            if (k == 0) {
                return current.val;
            }

            current = current.right;
        }

        return -1;
    }
}
