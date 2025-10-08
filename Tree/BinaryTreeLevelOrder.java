package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node != null) {
                    sub.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (sub.size() > 0) {
                res.add(sub);
            }
        }

        return res;
    }
}
