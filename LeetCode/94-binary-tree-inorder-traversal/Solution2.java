import java.util.ArrayList;
import java.util.List;

public class Solution2 {

  /**
   * Performs in-order traversal of a binary tree.
   * @param root The root of the binary tree.
   * @return A list containing the in-order traversal of the tree.
   */
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    inorder(root, answer); // Start the traversal from the root
    return answer; // Return the result of the in-order traversal
  }

  /**
   * Auxiliary function to perform in-order traversal recursively.
   * @param node The current node in the binary tree.
   * @param answer The list that stores the in-order traversal.
   */
  private void inorder(TreeNode node, List<Integer> answer) {
    if (node == null) {
      return;
    }

    inorder(node.left, answer); // Recursively visit left subtree first
    answer.add(node.val); // Visit root node
    inorder(node.right, answer); // Recursively visit right subtree last
  }
}
