/**
 * Performs a flood fill on a 2D image grid using Breadth‑First Search (BFS).
 *
 * Recolors all pixels connected 4‑directionally to the starting pixel (sr, sc)
 * that share the same original color. BFS processes pixels iteratively using
 * a queue, expanding outward until no more matching pixels remain.
 *
 * @param image The 2D grid of pixel colors.
 * @param sr Starting row index.
 * @param sc Starting column index.
 * @param color The new color to apply to the connected region.
 * @returns The modified image after flood fill.
 */
function floodFill(
  image: number[][],
  sr: number,
  sc: number,
  color: number,
): number[][] {
  const original = image[sr][sc];
  if (original === color) {
    return image;
  }

  const m = image.length;
  const n = image[0].length;

  // Initialize BFS queue with starting pixel
  const queue: [number, number][] = [];
  queue.push([sr, sc]);
  image[sr][sc] = color;

  // BFS expansion loop
  while (queue.length > 0) {
    const [r, c] = queue.shift() as [number, number];

    // Four-directional neighbors: bottom, top, right, left
    const dirs = [
      [1, 0],
      [-1, 0],
      [0, 1],
      [0, -1],
    ];

    for (const [dr, dc] of dirs) {
      const nr = r + dr;
      const nc = c + dc;

      // Bounds checks
      if (nr < 0 || nr >= m) {
        continue;
      }
      if (nc < 0 || nc >= n) {
        continue;
      }

      // Color mismatch check
      if (image[nr][nc] !== original) {
        continue;
      }

      // Recolor and enqueue neighbor
      image[nr][nc] = color;
      queue.push([nr, nc]);
    }
  }

  return image;
}
