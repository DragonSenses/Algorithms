function isNumber(s: string): boolean {
  let seenDigit = false;
  let seenExponent = false;
  let seenDot = false;

  for (let i = 0; i < s.length; i++) {
    const curr = s[i];

    if (curr >= '0' && curr <= '9') {
      seenDigit = true;
    } else if (curr === '+' || curr === '-') {
      if (i > 0 && s[i-1] !== 'e' && s[i-1] !== 'E') {
        return false;
      }
    } else if (curr === 'e' || curr === 'E') {
      if (seenExponent || !seenDigit) {
        return false;
      }
      seenExponent = true;
      seenDigit = false;
    } else if (curr === '.') {
      if (seenDot || seenExponent) {
        return false;
      }
      seenDot = true;
    } else {
      // Any character outside valid ones makes the string invalid
      return false;
    }
  }

  return seenDigit;
};