function addBinary(a: string, b: string): string {
  let result: string[] = [];
  let carry = 0;
  let i = a.length - 1;
  let j = b.length - 1;

  while (i >= 0 || j >= 0) {
    let sum = carry;
    if (i >= 0) {
      sum += parseInt(a.charAt(i--));
    }
    if (j >= 0) {
      sum += parseInt(b.charAt(j--));
    }
    result.push((sum % 2).toString());
    carry = Math.floor(sum / 2);
  }

  if (carry !== 0) {
    result.push(carry.toString());
  }

  return result.reverse().join("");
}