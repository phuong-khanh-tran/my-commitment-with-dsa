package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class IsSubTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            boolean isSub = isSameTree(node, subRoot);
            if (isSub) {
                return true;
            }
            if (node != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return false;
    }

    private boolean isSameTree(TreeNode q, TreeNode p) {
        if (q == null && p == null) {
            return true;
        } else if (q != null && p != null && q.val == p.val) {
            return isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
        } else {
            return false;
        }
    }
}
