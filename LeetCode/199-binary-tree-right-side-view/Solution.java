import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Computes the right-side view of a binary tree using BFS. Each level is traversed left-to-right,
 * and the last node encountered at that level is recorded as the visible node.
 */
class Solution {

  /**
   * Returns the list of node values visible from the right side.
   *
   * @param root the root of the binary tree
   * @return a list of integers representing the rightmost node at each depth
   */
  public List<Integer> rightSideView(TreeNode root) {
    // Result list storing the rightmost node per level
    List<Integer> rightside = new ArrayList<>();
    if (root == null)
      return rightside;

    // Queue holding nodes for the next level of BFS
    Queue<TreeNode> nextLevel = new LinkedList<>();
    nextLevel.add(root);

    // Process the tree level by level
    while (!nextLevel.isEmpty()) {
      // Move all nodes from nextLevel into currLevel
      Queue<TreeNode> currLevel = nextLevel;
      nextLevel = new LinkedList<>();

      TreeNode node = null; // Tracks the last node processed at this level

      // Traverse all nodes in the current level
      while (!currLevel.isEmpty()) {
        node = currLevel.poll();

        // Enqueue children for the next level
        if (node.left != null) {
          nextLevel.add(node.left);
        }
        if (node.right != null) {
          nextLevel.add(node.right);
        }
      }

      // node now holds the rightmost node of this level
      if (node != null) {
        rightside.add(node.val);
      }
    }

    return rightside;
  }
}
