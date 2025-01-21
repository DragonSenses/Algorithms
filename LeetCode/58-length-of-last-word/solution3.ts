function lengthOfLastWord(s: string): number {
  s = s.trim();

  const lastSpaceIndex = s.lastIndexOf(' ');

  return (lastSpaceIndex === -1) ? s.length : s.length - lastSpaceIndex - 1;
}
