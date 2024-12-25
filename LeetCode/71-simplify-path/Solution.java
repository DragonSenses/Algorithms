import java.util.Stack;

class Solution {
  /**
   * Simplifies the given absolute path for a Unix-style file system. The path must be transformed
   * into its simplified canonical form.
   * 
   * @param path The absolute path to be simplified.
   * @return The simplified canonical path.
   */
  public String simplifyPath(String path) {
    // Initialize a stack to keep track of valid directory names
    Stack<String> stack = new Stack<>();

    // Split the input path by "/" to get individual components
    String[] components = path.split("/");

    for (String directory : components) {
      // Ignore "." (current directory) or empty components resulting from multiple slashes
      if (!directory.equals(".") && !directory.isEmpty()) {
        if (directory.equals("..")) {
          // Pop the stack if ".." (parent directory) is encountered and the stack is not empty
          if (!stack.isEmpty()) {
            stack.pop();
          }
        } else {
          // Push valid directory names onto the stack
          stack.add(directory);
        }
      }
    }

    // Construct the simplified path from the stack elements
    StringBuilder simplifiedPath = new StringBuilder();
    for (String dir : stack) {
      simplifiedPath.append("/");
      simplifiedPath.append(dir);
    }

    // Ensure the path starts with "/" and handles the root directory case
    return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
  }
}
