package Tree;

import java.util.Stack;

public class MaximumDepthBinaryTreeIterativeDFS {
    public int maxDepth(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int depth = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.pop();
            TreeNode node = top.getKey();
            int dep = top.getValue();

            if (node != null) {
                depth = Math.max(depth, dep);
                stack.push(new Pair<TreeNode, Integer>(node.left, dep + 1));
                stack.push(new Pair<TreeNode, Integer>(node.right, dep + 1));
            }
        }

        return depth;
    }
}
