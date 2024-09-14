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

## **Algorithm**

1. **Initialize Variables**:
   - `minPrice`: Set this to a very high value initially (infinity) to ensure any price in the array will be lower.
   - `maxProfit`: Set this to 0 initially, as we haven't made any transactions yet.

2. **Iterate Through Prices**:
   - For each price in the array, do the following:
     - **Update `minPrice`**: If the current price is lower than `minPrice`, update `minPrice`.
     - **Calculate Profit**: Calculate the potential profit if we were to sell at the current price (`current price - minPrice`).
     - **Update `maxProfit`**: If the calculated profit is higher than `maxProfit`, update `maxProfit`.

3. **Return `maxProfit`**:
   - After iterating through all prices, `maxProfit` will contain the maximum profit that can be achieved.

## **Complexity Analysis**

Let `n` be the size of array `prices`.

**Time complexity**: `O(n)`
  - *Single Pass:* We iterate through every element of `prices` exactly once.

**Space complexity**: `O(1)`
  - No matter how long the input is, we are only ever using 2 variables: `minPrice` and `maxProfit`

## **Implementation**

### Java

Using a `for-each` loop:

```java
public class Solution {
  public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    
    for (int price : prices) {
      if (price < minPrice) {
        minPrice = price;
      } else if (price - minPrice > maxProfit) {
        maxProfit = price - minPrice;
      }
    }
    
    return maxProfit;
  }
}
```

Using a traditional `for-loop`:

```java
class Solution {
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
```

#### `for-each` vs `for-loop`

In Java, the performance difference between a `for-each` loop and a traditional `for` loop is generally negligible for most use cases, especially when iterating over arrays. However, there are some nuances to consider:

##### `for-each` Loop

- **Syntax**: Simplifies the code and makes it more readable.
- **Performance**: Internally, the `for-each` loop uses an iterator for collections, but for arrays, it is optimized to be as efficient as a traditional `for` loop.
- **Use Case**: Ideal for iterating over collections and arrays when you don't need to modify the index or access the index directly.

##### Traditional `for` Loop

- **Syntax**: Provides more control over the iteration process.
- **Performance**: Can be slightly more efficient in certain scenarios, especially if you need to access the index or modify the array during iteration.
- **Use Case**: Useful when you need to know the index or perform operations that require index manipulation.

In this specific case of iterating over an array to find the maximum profit, both loops will perform similarly. The choice between them can be based on readability and personal preference. If you don't need to access the index, the `for-each` loop is more concise and readable. If you need to manipulate the index or perform more complex operations, the traditional `for` loop might be more appropriate.

### TypeScript

```typescript
function maxProfit(prices: number[]): number {
  let minPrice = Number.MAX_VALUE;
  let maxProfit = 0;

  for (let i = 0; i < prices.length; i++) {
    if (prices[i] < minPrice) {
      minPrice = prices[i];
    } else if (prices[i] - minPrice > maxProfit) {
      maxProfit = prices[i] - minPrice;
    }
  }

  return maxProfit;
};
```
