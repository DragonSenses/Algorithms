/**
 * Restores possible valid IP addresses from the given input string.
 *
 * @param {string} s - The input string containing only digits.
 * @returns {string[]} - A list of all possible valid IP addresses.
 */
function restoreIpAddresses(s: string): string[] {
  const result: string[] = [];
  const len = s.length;

  // Iterate over the possible lengths for the first segment (len1).
  for (let len1 = Math.max(1, len - 9); len1 <= Math.min(3, len - 3); len1++) {
    const part1 = s.slice(0, len1);
    if (!isValidSegment(part1)) continue;

    // Iterate over the possible lengths for the second segment (len2).
    for (
      let len2 = Math.max(1, len - len1 - 6);
      len2 <= Math.min(3, len - len1 - 2);
      len2++
    ) {
      const part2 = s.slice(len1, len1 + len2);
      if (!isValidSegment(part2)) continue;

      // Iterate over the possible lengths for the third segment (len3).
      for (
        let len3 = Math.max(1, len - len1 - len2 - 3);
        len3 <= Math.min(3, len - len1 - len2 - 1);
        len3++
      ) {
        const part3 = s.slice(len1 + len2, len1 + len2 + len3);
        const part4 = s.slice(len1 + len2 + len3);

        // Check if both the third and fourth segments are valid.
        if (isValidSegment(part3) && isValidSegment(part4)) {
          result.push(`${part1}.${part2}.${part3}.${part4}`);
        }
      }
    }
  }

  return result;
}

/**
 * Validates whether the given segment is a valid IP address segment.
 *
 * @param {string} segment - The segment to validate.
 * @returns {boolean} - True if the segment is valid, false otherwise.
 */
function isValidSegment(segment: string): boolean {
  if (segment.length === 0 || segment.length > 3) return false;
  if (segment[0] === "0" && segment.length > 1) return false;
  const value = parseInt(segment, 10);
  return value >= 0 && value <= 255;
}
