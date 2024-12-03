/**
 * Restores IP addresses from a given string using backtracking.
 * @param {string} s - The input string containing digits.
 * @returns {string[]} - An array of valid IP addresses.
 */
function restoreIpAddresses(s: string): string[] {
  const result: string[] = [];
  backtrack(s, 0, [], result);
  return result;
};

/**
 * Helper function to perform backtracking and restore IP addresses.
 * @param {string} s - The input string.
 * @param {number} startIndex - The current start index in the string.
 * @param {number[]} dots - List of segment lengths.
 * @param {string[]} result - List to store the resulting IP addresses.
 */
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

/**
 * Validates whether the segment of the string is a valid IP address segment.
 * @param {string} s - The input string.
 * @param {number} start - The start index of the segment.
 * @param {number} length - The length of the segment.
 * @returns {boolean} - True if the segment is valid, false otherwise.
 */
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
