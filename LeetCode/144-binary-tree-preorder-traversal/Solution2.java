import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  /**
   * Method to perform a recursive preorder traversal of a binary tree.
   * 
   * @param root The root node of the binary tree.
   * @return A list of integers representing the preorder traversal.
   */
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    preorder(root, answer);
    return answer;
  }

  /**
   * Helper method to perform the preorder traversal recursively.
   * 
   * @param node   The current node being visited.
   * @param answer The list storing the preorder traversal result.
   */
  private void preorder(TreeNode node, List<Integer> answer) {
    if (node == null) {
      return;
    }
    answer.add(node.val);
    preorder(node.left, answer);
    preorder(node.right, answer);
  }
}
