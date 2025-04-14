import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
  public boolean isSymmetric(TreeNode root) {
    
    // Empty tree is symmetric
    if (root == null) {
      return true;
    }

    Deque<TreeNode[]> deque = new ArrayDeque<>();
    deque.add(new TreeNode[] {root.left, root.right});

    while (!deque.isEmpty()) {
      TreeNode[] pair = deque.poll();
      TreeNode left = pair[0];
      TreeNode right = pair[1];

    }

    return false;
  }
}
