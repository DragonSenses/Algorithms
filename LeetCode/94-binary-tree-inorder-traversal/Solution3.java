import java.util.ArrayList;
import java.util.List;

/**
 * This class provides a solution to perform Morris Traversal on a binary tree.
 * Morris Traversal is an in-order traversal algorithm with O(1) space
 * complexity.
 */
public class Solution3 {

  /**
   * Performs Morris Traversal on the binary tree and returns the in-order
   * traversal as a list of integers.
   *
   * @param root the root node of the binary tree
   * @return a list of integers representing the in-order traversal of the binary
   *         tree
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode current = root;

    // Traverse the tree
    while (current != null) {
      if (current.left == null) {
        // If there is no left child, visit this node and move to the right
        result.add(current.val);
        current = current.right;
      } else {
        // Find the inorder predecessor of current
        TreeNode predecessor = current.left;
        while (predecessor.right != null && predecessor.right != current) {
          predecessor = predecessor.right;
        }

        if (predecessor.right == null) {
          // Establish the link to return to the current node
          predecessor.right = current;
          current = current.left;
        } else {
          // Remove the established link and visit this node
          predecessor.right = null;
          result.add(current.val);
          current = current.right;
        }
      }
    }

    return result;
  }
}