public class Codec {

  private static final String NULL_MARKER = "#";
  private static final String DELIM = ",";

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeAux(root, sb);
    return sb.toString();
  }

  private void serializeAux(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append(NULL_MARKER).append(DELIM);
      return;
    }

    sb.append(node.val).append(DELIM);
    serializeAux(node.left, sb);
    serializeAux(node.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

  }
}