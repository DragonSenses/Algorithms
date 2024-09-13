# 121. Best Time to Buy and Sell Stock

You are given an array prices where `prices[i]` is the price of a given stock on the `ith` day.

You want to maximize your profit by choosing a **single day** to buy one stock and choosing a **different day in the future** to sell that stock.

Return *the maximum profit you can achieve from this transaction*. If you cannot achieve any profit, return `0`.


#### Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

#### Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

#### Constraints:

  - `1 <= prices.length <= 10^5`
  - `0 <= prices[i] <= 10^4`

# Solution

- [**Single Pass**](#single-pass)
  - Time complexity: `O(n)`

# Single Pass

## **Intuition**

The goal is to find the maximum profit by buying and selling the stock on different days. To achieve this, we need to keep track of the minimum price encountered so far and calculate the potential profit at each step.

Let's take the first example array:

```sh
prices = [7, 1, 5, 3, 6, 4]
```

We can visualize this data as a graph where:
- The **y-axis** represents the stock prices (`prices[i]`).
- The **x-axis** represents the days (`i`).

In this graph, the points of interest are the **peaks** and **valleys**. Our goal is to find the largest price following each valley, as the difference between these points could represent the maximum profit.

To achieve this, we can maintain two variables:
- `minPrice`: This represents the smallest valley encountered so far.
- `maxProfit`: This represents the maximum profit (the largest difference between the selling price and `minPrice`) obtained so far.

We can solve this problem with a single pass through the array:

1. **Initialize `minPrice`** to a very high value (infinity) to ensure any price will be lower initially.
2. **Initialize `maxProfit`** to 0, as no transactions have been made yet.
3. **Iterate through the prices**:
   - For each price, update `minPrice` if the current price is lower.
   - Calculate the potential profit if selling at the current price (`price - minPrice`).
   - Update `maxProfit` if the calculated profit is higher.

By the end of the iteration, `maxProfit` will contain the maximum profit that can be achieved.

### Example Walkthrough

Let's take the example `prices = [7, 1, 5, 3, 6, 4]`:

- Initialize `minPrice = ∞`, `maxProfit = 0`.
- Iterate through the prices:
  - Day 1: Price = 7
    - `minPrice` = 7 (updated)
    - `maxProfit` = 0 (no profit yet)
  - Day 2: Price = 1
    - `minPrice` = 1 (updated)
    - `maxProfit` = 0 (no profit yet)
  - Day 3: Price = 5
    - `minPrice` = 1 (unchanged)
    - `maxProfit` = 5 - 1 = 4 (updated)
  - Day 4: Price = 3
    - `minPrice` = 1 (unchanged)
    - `maxProfit` = 4 (unchanged)
  - Day 5: Price = 6
    - `minPrice` = 1 (unchanged)
    - `maxProfit` = 6 - 1 = 5 (updated)
  - Day 6: Price = 4
    - `minPrice` = 1 (unchanged)
    - `maxProfit` = 5 (unchanged)

Finally, the maximum profit is 5.

