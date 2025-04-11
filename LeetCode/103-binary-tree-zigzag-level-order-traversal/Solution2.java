import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution2 class provides a method to perform an iterative zigzag level order traversal 
 * of a binary tree. In zigzag traversal, nodes at each level are alternately traversed 
 * from left-to-right and right-to-left.
 */
class Solution2 {

  /**
   * Performs zigzag level order traversal on a binary tree.
   *
   * @param root The root node of the binary tree.
   * @return A list of lists, where each sublist represents the values of nodes at a specific level
   *         in zigzag order.
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    // Initialize the result list to store level-wise node values
    List<List<Integer>> result = new ArrayList<>();

    // Edge case: if the tree is empty, return an empty result
    if (root == null) {
      return result;
    }

    // Use a queue for level order traversal
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root); // Start with the root node

    // Flag to control zigzag direction, starting with left-to-right
    boolean leftToRight = true;

    // Process nodes level by level
    while (!queue.isEmpty()) {
      int levelSize = queue.size(); // Number of nodes at the current level
      LinkedList<Integer> levelValues = new LinkedList<>(); // List to store node values for this
                                                            // level

      // Traverse all nodes at the current level
      for (int i = 0; i < levelSize; i++) {
        TreeNode currentNode = queue.poll(); // Dequeue the current node

        // Add the current node's value to the level list based on traversal direction
        if (leftToRight) {
          levelValues.addLast(currentNode.val); // Add to the end for left-to-right traversal
        } else {
          levelValues.addFirst(currentNode.val); // Add to the front for right-to-left traversal
        }

        // Enqueue the left and right children of the current node, if they exist
        if (currentNode.left != null) {
          queue.offer(currentNode.left);
        }
        if (currentNode.right != null) {
          queue.offer(currentNode.right);
        }
      }

      // Add the current level's values to the result list
      result.add(levelValues);

      // Toggle the zigzag direction for the next level
      leftToRight = !leftToRight;
    }

    // Return the final zigzag level order traversal
    return result;
  }
}
