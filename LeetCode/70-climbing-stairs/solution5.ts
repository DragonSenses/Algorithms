function climbStairs(n: number): number {
  const sqrt5 = Math.sqrt(5);

  const phi = (1 + sqrt5) / 2;

  const psi = (1 - sqrt5) / 2;

  return Math.round((Math.pow(phi, n + 1) - Math.pow(psi, n + 1)) / sqrt5);
}
