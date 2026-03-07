import java.util.LinkedList;
import java.util.Queue;

public class Codec2 {

  private static final String NULL_MARKER = "#";
  private static final String DELIM = ",";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if (root == null) {
      return NULL_MARKER;
    }

    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

     while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        sb.append(NULL_MARKER).append(DELIM);
        continue;
      }

      sb.append(node.val).append(DELIM);
      queue.offer(node.left);
      queue.offer(node.right);
    }

    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

  }
}
