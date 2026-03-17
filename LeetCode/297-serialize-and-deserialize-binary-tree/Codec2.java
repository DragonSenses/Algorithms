import java.util.LinkedList;
import java.util.Queue;

/**
 * Codec2 implements serialization and deserialization of a binary tree
 * using a Breadth-First Search (BFS) level-order traversal.
 *
 * Each node is emitted in level order, and null children are represented
 * using a NULL_MARKER token. This ensures the structure can be reconstructed
 * unambiguously during deserialization.
 */
public class Codec2 {

  private static final String NULL_MARKER = "#";
  private static final String DELIM = ",";

  /**
   * Serializes a binary tree into a single string using BFS level order.
   *
   * @param root the root of the binary tree
   * @return a comma-delimited string encoding the tree structure
   */
  public String serialize(TreeNode root) {
    // Empty tree -> return null marker
    if (root == null) {
      return NULL_MARKER;
    }

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    // Standard BFS traversal
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        // Represent missing children explicitly
        sb.append(NULL_MARKER).append(DELIM);
        continue;
      }

      // Emit node value
      sb.append(node.val).append(DELIM);

      // Enqueue children (may be null)
      queue.offer(node.left);
      queue.offer(node.right);
    }

    return sb.toString();
  }

  /**
   * Deserializes a BFS-encoded string back into a binary tree.
   *
   * @param data the serialized tree string
   * @return the reconstructed binary tree root
   */
  public TreeNode deserialize(String data) {
    // Empty input -> empty tree
    if (data == null || data.isEmpty()) {
      return null;
    }

    String[] tokens = data.split(DELIM);

    // First token represents the root
    if (tokens[0].equals(NULL_MARKER)) {
      return null;
    }

    // Create root node
    TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int index = 1;

    // BFS reconstruction: assign children level by level
    while (!queue.isEmpty() && index < tokens.length) {
      TreeNode parent = queue.poll();

      // ----- Left child -----
      String leftToken = tokens[index++];
      if (!leftToken.equals(NULL_MARKER)) {
        TreeNode leftNode = new TreeNode(Integer.parseInt(leftToken));
        parent.left = leftNode;
        queue.offer(leftNode);
      }

      // ----- Right child -----
      if (index < tokens.length) {
        String rightToken = tokens[index++];
        if (!rightToken.equals(NULL_MARKER)) {
          TreeNode rightNode = new TreeNode(Integer.parseInt(rightToken));
          parent.right = rightNode;
          queue.offer(rightNode);
        }
      }
    }

    return root;
  }
}