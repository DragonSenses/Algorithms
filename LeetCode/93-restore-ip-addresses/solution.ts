function restoreIpAddresses(s: string): string[] {
  const result: string[] = [];
  backtrack(s, 0, [], result);
  return result;
};

function backtrack(
  s: string,
  startIndex: number,
  dots: number[],
  result: string[]
): void {
  const remainingLength = s.length - startIndex;
  const remainingNumberOfIntegers = 4 - dots.length;

  // Check if the remaining characters can form valid segments.
  if (
    remainingLength > remainingNumberOfIntegers * 3 ||
    remainingLength < remainingNumberOfIntegers
  ) {
    return;
  }

  // If we have 1 segment left to place.
  if (remainingNumberOfIntegers === 1) {
    if (isValidSegment(s, startIndex, remainingLength)) {
      let ipAddress = "";
      let last = 0;
      // Construct the IP address from the segments.
      for (const dot of dots) {
        ipAddress += s.slice(last, last + dot) + ".";
        last += dot;
      }
      ipAddress += s.slice(startIndex);
      result.push(ipAddress);
    }
    return;
  }

  // Try placing a dot at every possible position.
  for (let curPos = 1; curPos <= Math.min(3, remainingLength); curPos++) {
    if (isValidSegment(s, startIndex, curPos)) {
      dots.push(curPos);
      backtrack(s, startIndex + curPos, dots, result);
      dots.pop();
    }
  }
}

function isValidSegment(s: string, start: number, length: number): boolean {
  if (length === 1) {
    return true;
  }
  if (s.charAt(start) === "0") {
    return false;
  }
  if (length === 2) {
    const segment = parseInt(s.slice(start, start + 2), 10);
    return segment >= 10 && segment <= 99;
  }
  if (length === 3) {
    const segment = parseInt(s.slice(start, start + 3), 10);
    return segment >= 100 && segment <= 255;
  }
  return false;
}
