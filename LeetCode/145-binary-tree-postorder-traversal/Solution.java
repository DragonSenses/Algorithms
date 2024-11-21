import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

  /**
   * Performs an iterative postorder traversal of a binary tree.
   *
   * @param root The root node of the binary tree.
   * @return A list of integers representing the postorder traversal.
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> answer = new ArrayList<>();
    if (root == null) {
      return answer;
    }

    // Stack to traverse the tree
    Deque<TreeNode> stack = new ArrayDeque<>();
    // Output stack to reverse the order
    Deque<TreeNode> output = new ArrayDeque<>();

    // Start with the root node
    stack.push(root);

    // Traverse the tree
    while (!stack.isEmpty()) {
      // Pop the current node from the stack
      TreeNode currNode = stack.pop();
      // Push the current node to the output stack
      output.push(currNode);

      // Push the left child to the stack if it exists
      if (currNode.left != null) {
        stack.push(currNode.left);
      }
      // Push the right child to the stack if it exists
      if (currNode.right != null) {
        stack.push(currNode.right);
      }
    }

    // Collect nodes in postorder from the output stack
    while (!output.isEmpty()) {
      answer.add(output.pop().val);
    }

    return answer;
  }

  /**
   * Definition for a binary tree node.
   */
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Creates an instance of TreeNode.
     *
     * @param x The value of the node.
     */
    TreeNode(int x) {
      val = x;
    }
  }
}
