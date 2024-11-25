import java.util.ArrayDeque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

  public boolean isEqual(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (q == null || p == null) return false;
    if (p.val != q.val) return false;
    return true;
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (!isEqual(p, q)) return false;

    ArrayDeque<TreeNode> queueP = new ArrayDeque<>();
    ArrayDeque<TreeNode> queueQ = new ArrayDeque<>();
    queueP.addLast(p);
    queueQ.addLast(q);

    while (!queueP.isEmpty()) {
      p = queueP.removeFirst();
      q = queueQ.removeFirst();

      if (!isEqual(p, q)) return false;
      if (p != null) {
        queueP.addLast(p.left);
        queueQ.addLast(q.left);
        queueP.addLast(p.right);
        queueQ.addLast(q.right);
      }
    }
    return true;
  }
}
