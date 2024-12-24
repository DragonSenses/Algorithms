function simplifyPath(path: string): string {
  // Initialize a stack to keep track of valid directory names
  const stack: string[] = [];

  // Split the input path by "/" to get individual components
  const components = path.split("/");

  for (const directory of components) {
    // Ignore "." (current directory) or empty components resulting from multiple slashes
    if (directory === "." || directory === "") {
      continue;
    } else if (directory === "..") {
      // Pop the stack if ".." (parent directory) is encountered and the stack is not empty
      if (stack.length > 0) {
        stack.pop();
      }
    } else {
      // Push valid directory names onto the stack
      stack.push(directory);
    }
  }

  // Construct the simplified path from the stack elements
  const simplifiedPath = "/" + stack.join("/");

  // Return the simplified canonical path
  return simplifiedPath;
};
