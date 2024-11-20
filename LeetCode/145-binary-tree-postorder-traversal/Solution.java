import java.util.ArrayList;
import java.util.List;

/**
 * Solution class to perform postorder traversal on a binary tree.
 */
public class Solution {

  /**
   * Performs a recursive postorder traversal of a binary tree.
   *
   * @param root The root node of the binary tree.
   * @return A list of integers representing the postorder traversal.
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    postorder(root, answer);
    return answer;
  }

  /**
   * Helper method to recursively perform postorder traversal.
   *
   * @param node The current node being processed.
   * @param answer The list to store the traversal result.
   */
  private void postorder(TreeNode node, List<Integer> answer) {
    // Base case: If the node is null, return
    if (node == null) {
      return;
    }

    // Recursively traverse the left subtree
    postorder(node.left, answer);

    // Recursively traverse the right subtree
    postorder(node.right, answer);

    // Add the current node's value to the result list
    answer.add(node.val);
  }
}
