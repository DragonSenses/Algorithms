function floodFill(image: number[][], sr: number, sc: number, color: number): number[][] {
  const original = image[sr][sc];
  if (original === color) {
    return image;
  }

  const m = image.length;
  const n = image[0].length;

  const queue: [number, number][] = [];
  queue.push([sr, sc]);
  image[sr][sc] = color;

  while (queue.length > 0) {
    const [r, c] = queue.shift() as [number, number];

    const dirs = [
      [1, 0],
      [-1, 0],
      [0, 1],
      [0, -1]
    ];

    for (const [dr, dc] of dirs) {
      const nr = r + dr;
      const nc = c + dc;
    }
  }

}
