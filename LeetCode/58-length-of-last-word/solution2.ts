function lengthOfLastWord(s: string): number {
  let i = s.length - 1;

  let length = 0;

  while (i >= 0) {
    if (s.charAt(i) !== " ") {
      while (i >= 0 && s.charAt(i) !== " ") {
        length++;
        i--;
      }
      break;
    }
    i--;
  }

  return length;
}