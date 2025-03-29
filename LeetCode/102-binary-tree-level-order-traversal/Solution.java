import java.util.ArrayList;
import java.util.List;

/**
 * Solution class to perform level order traversal on a binary tree. Each level of the tree is
 * represented as a separate list.
 */
class Solution {

  // List to store the levels of the binary tree.
  private List<List<Integer>> levels = new ArrayList<>();

  /**
   * Performs level order traversal of a binary tree. Returns a list of lists, where each inner list
   * contains the node values at a specific level.
   *
   * @param root The root node of the binary tree.
   * @return List of lists representing node values at each level.
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    // Edge case: If the tree is empty, return an empty list.
    if (root == null) {
      return levels;
    }

    // Start the recursive traversal from the root node at level 0.
    traverseLevels(root, 0);

    return levels;
  }

  /**
   * Recursively traverses the binary tree to build the level order representation. Adds each node's
   * value to the corresponding level's list.
   *
   * @param node The current node being processed.
   * @param level The level of the current node in the tree.
   */
  private void traverseLevels(TreeNode node, int level) {
    // Base case: If the node is null, end the traversal for this path.
    if (node == null) {
      return;
    }

    // Ensure the levels list has a sublist for the current level.
    if (levels.size() == level) {
      levels.add(new ArrayList<>());
    }

    // Add the current node's value to the list corresponding to its level.
    levels.get(level).add(node.val);

    // Recursively traverse the left and right subtrees, incrementing the level.
    traverseLevels(node.left, level + 1);
    traverseLevels(node.right, level + 1);
  }
}
