import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This solution performs a level-order traversal of a binary tree and returns
 * the values of nodes level by level.
 */
class Solution2 {

  /**
   * Performs level-order traversal of a binary tree.
   *
   * @param root the root of the binary tree
   * @return a list of lists, where each sublist contains the values of the nodes at one level
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    // Initialize levels list
    List<List<Integer>> levels = new ArrayList<>();

    // Edge case: If the tree is empty, return an empty list
    if (root == null) {
      return levels;
    }

    // Initialize the queue
    Queue<TreeNode> queue = new LinkedList<>();
    // Add the root node to the queue
    queue.add(root);

    while (!queue.isEmpty()) {
      // Number of nodes in the current level
      int levelSize = queue.size();
      // Sublist for the current level
      List<Integer> currentLevel = new ArrayList<>();

      for (int i = 0; i < levelSize; i++) {
        // Remove the front node from the queue
        TreeNode node = queue.poll();
        // Add the node's value to the current level
        currentLevel.add(node.val);

        // Add the left child to the queue (if it exists)
        if (node.left != null) {
          queue.add(node.left);
        }
        // Add the right child to the queue (if it exists)
        if (node.right != null) {
          queue.add(node.right);
        }
      }

      // Add the current level to the result
      levels.add(currentLevel);
    }

    // Return the result list
    return levels;
  }
}
