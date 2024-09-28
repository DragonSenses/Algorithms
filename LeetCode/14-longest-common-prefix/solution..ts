/**
 * Finds the longest common prefix string amongst an array of strings using the
 * binary search approach.
 *
 * @param strs an array of strings
 * @return the longest common prefix string, or an empty string if there is no
 *         common prefix
 */
function longestCommonPrefix(strs: string[]): string {
  if (strs == null || strs.length === 0) {
    return "";
  }

  let minLen = Number.MAX_VALUE;
  for (const str of strs) {
    minLen = Math.min(minLen, str.length);
  }

  let low = 0;
  let high = minLen;
  while (low <= high) {
    const mid = Math.floor((low + high) / 2);
    if (isCommonPrefix(strs, mid)) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
  }

  return strs[0].substring(0, Math.floor((low + high) / 2));
};

/**
 * Checks if a prefix of given length is common to all strings.
 *
 * @param strs the array of strings
 * @param len  the length of the prefix
 * @return true if the prefix is common to all strings, false otherwise
 */
function isCommonPrefix(strs: string[], len: number): boolean {
  const prefix = strs[0].substring(0, len);
  for (let i = 1; i < strs.length; i++) {
    if (!strs[i].startsWith(prefix)) {
      return false;
    }
  }
  return true;
};
