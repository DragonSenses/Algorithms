import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  /**
   * Inverts a binary tree by swapping the left and right children of all nodes.
   *
   * @param root the root of the binary tree
   * @return the root of the inverted binary tree
   */
  public TreeNode invertTree(TreeNode root) {
    // Base case: If the current node is null, return null
    if (root == null) {
      return null;
    }

    // Initialize the queue and add the root node
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    // Process nodes in the queue until it is empty
    while (!queue.isEmpty()) {
      TreeNode current = queue.poll();

      // Swap the left and right children
      TreeNode temp = current.left;
      current.left = current.right;
      current.right = temp;

      // Add the non-null children to the queue
      if (current.left != null) {
        queue.add(current.left);
      }
      if (current.right != null) {
        queue.add(current.right);
      }
    }

    // Return the root of the inverted tree
    return root;
  }
}
