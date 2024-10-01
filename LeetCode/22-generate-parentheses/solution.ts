function generateParenthesis(n: number): string[] {
  const result: string[] = [];
  const queue: string[] = [""];
  
  while (queue.length > 0) {
    const current = queue.shift()!;
    if (current.length === 2 * n) {
      if (isValid(current)) {
        result.push(current);
      }
    } else {
      queue.push(current + "(");
      queue.push(current + ")");
    }
  }
  
  return result;
};

function isValid(parenthesis: string): boolean {
  let open_count = 0;
  for (const p of parenthesis) {
    if (p === '(') {
      open_count++;
    } else {
      open_count--;
    }
    if (open_count < 0) {
      return false;
    }
  }
  return open_count === 0;
};
