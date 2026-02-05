/**
 * Codec for serializing and deserializing a binary tree using
 * preorder traversal with explicit null markers.
 */
public class Codec {

  private static final String NULL_MARKER = "#";
  private static final String DELIM = ",";

  /**
   * Serializes a binary tree into a comma-delimited preorder string.
   *
   * @param root the root of the tree
   * @return serialized representation of the tree
   */
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializeAux(root, sb);
    return sb.toString();
  }

  /**
   * Recursively appends node values (or null markers) to the output buffer
   * using preorder traversal.
   */
  private void serializeAux(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append(NULL_MARKER).append(DELIM);
      return;
    }

    sb.append(node.val).append(DELIM);
    serializeAux(node.left, sb);
    serializeAux(node.right, sb);
  }

  /**
   * Deserializes a comma-delimited preorder string back into a binary tree.
   *
   * @param data serialized tree data
   * @return reconstructed tree root
   */
  public TreeNode deserialize(String data) {
    String[] tokens = data.split(DELIM);
    int[] index = new int[1]; // shared cursor into token stream
    return deserializeAux(tokens, index);
  }

  /**
   * Recursively rebuilds the tree by consuming tokens in preorder.
   * The index array acts as a mutable pointer shared across recursion.
   */
  private TreeNode deserializeAux(String[] tokens, int[] index) {
    String token = tokens[index[0]];
    index[0]++;

    if (token.equals(NULL_MARKER)) {
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(token));
    node.left = deserializeAux(tokens, index);
    node.right = deserializeAux(tokens, index);
    return node;
  }
}