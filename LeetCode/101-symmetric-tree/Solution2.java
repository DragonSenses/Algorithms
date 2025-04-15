import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Solution2 class to check if a binary tree is symmetric iteratively.
 */
class Solution2 {

  /**
   * Determines whether a binary tree is symmetric around its center. Uses an iterative approach
   * with a deque for optimal performance.
   *
   * @param root The root of the binary tree.
   * @return True if the tree is symmetric, false otherwise.
   */
  public boolean isSymmetric(TreeNode root) {
    // An empty tree is symmetric
    if (root == null) {
      return true;
    }

    // Initialize a deque to store pairs of nodes for comparison
    Deque<TreeNode[]> deque = new ArrayDeque<>();

    // Add the first pair (left and right subtrees of the root)
    deque.add(new TreeNode[] {root.left, root.right});

    // Process node pairs iteratively
    while (!deque.isEmpty()) {
      // Retrieve and remove the first pair of nodes
      TreeNode[] pair = deque.poll();
      TreeNode left = pair[0];
      TreeNode right = pair[1];

      // Check if both nodes are null (symmetric at this level)
      if (left == null && right == null) {
        continue;
      }

      // If one node is null but the other is not, the tree is asymmetric
      if (left == null || right == null) {
        return false;
      }

      // If node values do not match, the tree is asymmetric
      if (left.val != right.val) {
        return false;
      }

      // Add mirror pairs of children to the deque for further comparisons
      deque.add(new TreeNode[] {left.left, right.right});
      deque.add(new TreeNode[] {left.right, right.left});
    }

    // If all pairs passed the symmetry checks, return true
    return true;
  }
}
