function titleToNumber(columnTitle: string): number {

  let result = 0;

  for (const c of columnTitle) {
    const value = c.charCodeAt(0) - 'A'.charCodeAt(0) + 1;
    result = result * 26 + value;
  }

  return result;
};