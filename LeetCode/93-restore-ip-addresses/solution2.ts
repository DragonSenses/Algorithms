function restoreIpAddresses(s: string): string[] {
  const result: string[] = [];
  const len = s.length;

  for (let len1 = Math.max(1, len - 9); len1 <= Math.min(3, len - 3); len1++) {
    const part1 = s.slice(0, len1);
    if (!isValidSegment(part1)) continue;

    for (
      let len2 = Math.max(1, len - len1 - 6);
      len2 <= Math.min(3, len - len1 - 2);
      len2++
    ) {
      const part2 = s.slice(len1, len1 + len2);
      if (!isValidSegment(part2)) continue;

      for (
        let len3 = Math.max(1, len - len1 - len2 - 3);
        len3 <= Math.min(3, len - len1 - len2 - 1);
        len3++
      ) {
        const part3 = s.slice(len1 + len2, len1 + len2 + len3);
        const part4 = s.slice(len1 + len2 + len3);

        if (isValidSegment(part3) && isValidSegment(part4)) {
          result.push(`${part1}.${part2}.${part3}.${part4}`);
        }
      }
    }
  }

  return result;
}

function isValidSegment(segment: string): boolean {
  if (segment.length === 0 || segment.length > 3) return false;
  if (segment[0] === "0" && segment.length > 1) return false;
  const value = parseInt(segment, 10);
  return value >= 0 && value <= 255;
}
