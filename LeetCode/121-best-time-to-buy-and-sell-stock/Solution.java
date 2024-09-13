class Solution {
  /**
   * Calculates the maximum profit that can be achieved from a single buy and sell transaction.
   *
   * @param prices An array where prices[i] is the price of a given stock on the ith day.
   * @return The maximum profit that can be achieved. If no profit is possible, returns 0.
   */
  public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++){
      if (prices[i] < minPrice) {
        minPrice = prices[i];
      } else if (prices[i] - minPrice > maxProfit) {
        maxProfit = prices[i] - minPrice;
      }
    }

    return maxProfit;
  }
}
