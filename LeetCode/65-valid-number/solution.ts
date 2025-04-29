function isNumber(s: string): boolean {
  let seenDigit = false;
  let seenExponent = false;
  let seenDot = false;

  for (let i = 0; i < s.length; i++) {
    const curr = s[i];

    if (curr >= '0' && curr <= '9') {
      seenDigit = true;
    }
  }
};