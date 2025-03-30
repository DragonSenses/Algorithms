import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<>(); // Initialize levels list

    // Edge case: If the tree is empty, return an empty list
    if (root == null) {
      return levels;
    }

    Queue<TreeNode> queue = new LinkedList<>(); // Initialize the queue
    queue.add(root); // Add the root node to the queue

    while (!queue.isEmpty()) {
      int levelSize = queue.size(); // Number of nodes in the current level
      List<Integer> currentLevel = new ArrayList<>(); // Sublist for current level

      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.poll(); // Remove the front node from the queue
        currentLevel.add(node.val); // Add the node's value to the current level

        // Add the left and right children to the queue (if they exist)
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }

    }

    return null;
  }
}
