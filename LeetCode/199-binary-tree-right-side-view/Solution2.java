import java.util.ArrayList;
import java.util.List;

/**
 * Computes the right-side view of a binary tree using a depth-first search.
 * The traversal visits right children before left children so the first node
 * encountered at each depth is the one visible from the right side.
 */
class Solution2 {

  /**
   * Returns the list of node values visible from the right side of the tree.
   *
   * @param root the root of the binary tree
   * @return a list containing the rightmost node at each depth level
   */
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> rightside = new ArrayList<>();
    dfs(root, 0, rightside);
    return rightside;
  }

  /**
   * Performs a right-first depth-first traversal.
   * Records the first node encountered at each depth, which corresponds
   * to the rightmost visible node for that level.
   *
   * @param node the current node being visited
   * @param depth the current depth in the tree
   * @param rightside the list accumulating the right-side view values
   */
  private void dfs(TreeNode node, int depth, List<Integer> rightside) {
    if (node == null) return;

    // If this is the first time reaching this depth, record the node's value
    if (depth == rightside.size()) {
      rightside.add(node.val);
    }

    // Visit right subtree first to ensure rightmost nodes are seen first
    dfs(node.right, depth + 1, rightside);
    dfs(node.left, depth + 1, rightside);
  }
}