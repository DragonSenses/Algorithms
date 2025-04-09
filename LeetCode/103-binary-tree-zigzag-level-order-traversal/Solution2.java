import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result; // Edge case: empty tree
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean leftToRight = true;

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      LinkedList<Integer> levelValues = new LinkedList<>();

      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll();

        // Add values to the list based on direction
        if (leftToRight) {
          levelValues.addLast(currentNode.val);
        } else {
          levelValues.addFirst(currentNode.val);
        }

      }

    }

    return result;
  }
}