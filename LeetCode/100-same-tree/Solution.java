import java.util.ArrayDeque;

class Solution {
  /**
   * Utility function to check if two nodes are equal.
   * 
   * @param p the first tree node
   * @param q the second tree node
   * @return true if both nodes are equal, false otherwise
   */
  public boolean isEqual(TreeNode p, TreeNode q) {
    // Both nodes are null
    if (p == null && q == null) return true;
    // One of the nodes is null
    if (q == null || p == null) return false;
    // Node values are not equal
    return p.val == q.val;
  }

  /**
   * Checks if two binary trees are the same.
   * This is an iterative approach using queues.
   * 
   * @param p the root node of the first tree
   * @param q the root node of the second tree
   * @return true if the trees are the same, false otherwise
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    // Check if both trees are initially empty
    if (p == null && q == null) return true;
    // Check if the initial nodes are not equal
    if (!isEqual(p, q)) return false;

    // Initialize deques to store nodes for comparison
    ArrayDeque<TreeNode> queueP = new ArrayDeque<>();
    ArrayDeque<TreeNode> queueQ = new ArrayDeque<>();
    queueP.addLast(p);
    queueQ.addLast(q);

    // Iterate while there are nodes to compare
    while (!queueP.isEmpty()) {
      p = queueP.removeFirst();
      q = queueQ.removeFirst();

      // If nodes are not equal
      if (!isEqual(p, q)) return false;

      // Check left children
      if (!isEqual(p.left, q.left)) return false;
      if (p.left != null && q.left != null) {
        queueP.addLast(p.left);
        queueQ.addLast(q.left);
      }

      // Check right children
      if (!isEqual(p.right, q.right)) return false;
      if (p.right != null && q.right != null) {
        queueP.addLast(p.right);
        queueQ.addLast(q.right);
      }
    }
    return true;
  }
}
