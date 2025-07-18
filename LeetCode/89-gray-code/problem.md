# 89. Gray Code

<p>An <strong>n-bit gray code sequence</strong> is a sequence of <code>2<sup>n</sup></code> integers where:</p>

<ul>
  <li>Every integer is in the <strong>inclusive</strong> range <code>[0, 2<sup>n</sup> - 1]</code>,</li>
  <li>The first integer is <code>0</code>,</li>
  <li>An integer appears <strong>no more than once</strong> in the sequence,</li>
  <li>The binary representation of every pair of <strong>adjacent</strong> integers differs by <strong>exactly one bit</strong>, and</li>
  <li>The binary representation of the <strong>first</strong> and <strong>last</strong> integers differs by <strong>exactly one bit</strong>.</li>
</ul>

<p>Given an integer <code>n</code>, return <em>any valid <strong>n-bit gray code sequence</strong></em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> n = 2
<strong>Output:</strong> [0,1,3,2]
<strong>Explanation:</strong>
The binary representation of [0,1,3,2] is [00,01,11,10].
- 0<u>0</u> and 0<u>1</u> differ by one bit
- <u>0</u>1 and <u>1</u>1 differ by one bit
- 1<u>1</u> and 1<u>0</u> differ by one bit
- <u>1</u>0 and <u>0</u>0 differ by one bit
[0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
- <u>0</u>0 and <u>1</u>0 differ by one bit
- 1<u>0</u> and 1<u>1</u> differ by one bit
- <u>1</u>1 and <u>0</u>1 differ by one bit
- 0<u>1</u> and 0<u>0</u> differ by one bit
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> [0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= n &lt;= 16</code></li>
</ul>

---

# Solution

- [Backtracking Approach](#backtracking-approach)
  - **Time Complexity: `O(n*2^n)`**
  - **Space Complexity: `O(2^n)`**
- [Iterative Approach](#iterative-approach)
  - **Time Complexity: `O(2^n)`**
  - **Space Complexity: `O(1)`**
- [Optimized Iterative Approach](#optimized-iterative-approach)
  - **Time Complexity: `O(2^n)`**
  - **Space Complexity: `O(1)`**

### **Problem Overview: Gray Code**  

#### **Definition**  
An **n-bit Gray Code sequence** is a sequence of \(2^n\) integers that satisfies the following conditions:  
- Every integer falls within the inclusive range \([0, 2^n - 1]\).  
- The first integer is **0**.  
- No integer appears more than **once** in the sequence.  
- The **binary representation** of every pair of adjacent integers differs by **exactly one bit**.  
- The **binary representation** of the first and last integers differs by **exactly one bit** (forming a cyclic sequence).  

#### **Task**  
Given an integer **n**, return any valid **n-bit Gray Code sequence**.

---

### **Examples**  

#### **Example 1**  
**Input:**  
```plaintext
n = 2
```  
**Valid Outputs:**  
```plaintext
[0,1,3,2]
```
or  
```plaintext
[0,2,3,1]
```  

**Binary Representation of [0,1,3,2]:**  
- **00** → **01** (1 bit change)  
- **01** → **11** (1 bit change)  
- **11** → **10** (1 bit change)  
- **10** → **00** (1 bit change)  

**Binary Representation of [0,2,3,1]:**  
- **00** → **10** (1 bit change)  
- **10** → **11** (1 bit change)  
- **11** → **01** (1 bit change)  
- **01** → **00** (1 bit change)  

#### **Example 2**  
**Input:**  
```plaintext
n = 1
```  
**Output:**  
```plaintext
[0,1]
```  
**Binary Representation:**  
- **0** → **1** (1 bit change)  
- **1** → **0** (1 bit change)  

---

### **Constraints**  
- \(1 \leq n \leq 16\)  

---

### **Observations: Gray Code**  

#### **Definition & Origin**  
The **Reflected Binary Code (RBC)** or **Gray Code**, named after **Frank Gray**, is an ordering of the **binary numeral system** where successive values differ by exactly **one bit** (binary digit)  
(Source: [Wikipedia](https://en.wikipedia.org/wiki/Gray_code)).  

#### **Example: Gray Code Sequence for \( n = 3 \) Bit Numbers**  
A valid Gray Code sequence for **\( n = 3 \)**:
```plaintext
[000, 001, 011, 010, 110, 111, 101, 100]
```  

This sequence demonstrates how each successive number differs by only **one bit** in its binary representation.  
For a clearer understanding, refer to the following table:  

#### **Figure 1: Decimal, Binary, Gray Code, and Gray Decimal Sequence (for \( n = 3 \))**  
![Figure 1. The decimal, binary, Gray code, Gray decimal sequence generated for n = 3 bits](img/89-1.jpg)  

### **Patterns in the Gray Code Sequence**  

Observing the **Gray Code sequence** reveals several key patterns:  
1. **Least Significant Bit (LSB) Pattern**  
   - The **0th bit** (from the right) in consecutive **Gray Decimal** numbers follows this pattern:  
     ```plaintext
     0 1 1 0
     ```
2. **First Bit Pattern**  
   - The **1st bit** in consecutive **Gray Decimal** numbers follows this pattern:  
     ```plaintext
     0 0 1 1 1 1 0
     ```
3. **Mirror Image Property**  
   - When these sequences are partitioned at their **center**, they form two **mirror image halves**.  
4. **Recursive Partitioning**  
   - Consider the first \(2^1 = 2\) numbers, then the first \(2^2 = 4\) numbers, and so on.  
   - Upon partitioning each sequence into two halves, a **mirror image pattern** emerges.  
   - The first **\( n - 1 \) bits** (from the right) appear **mirrored** between the two partitions.  
   - The **Most Significant Bit (MSB)** is set to **0** in the **first half** and **1** in the **second half**.

---

### **Key Observations for Implementation**  
- The Gray Code sequence should be returned in **decimal form**, not in binary.  
  - **For \( n = 3 \)**, a valid sequence is:  
    ```plaintext
    [0,1,3,2,6,7,5,4]
    ```
  - **Instead of:**  
    ```plaintext
    [000, 001, 011, 010, 110, 111, 101, 100]
    ```
- Multiple valid Gray Code sequences exist for a given **\( n \)**.  
  - **For \( n = 2 \)**, both of these sequences are valid:  
    ```plaintext
    [00, 01, 11, 10]
    ```
    ```plaintext
    [00, 10, 11, 01]
    ```
- The Gray Code sequence for **\( n \)** consists of exactly **\( 2^n \)** unique numbers, ranging from **0 to \( 2^n - 1 \)**.

# Backtracking Approach

## **Intuition**

The Gray Code sequence follows a key property: **adjacent numbers differ by exactly one bit** in their binary representation. Additionally, the sequence **always starts with 0**.

To construct a valid sequence, we can use **Depth-First Search (DFS)** with backtracking, ensuring that at each step, we **only add numbers** that meet the following conditions:  
1. **Uniqueness:** The number has **not** already been used in the sequence.  
2. **One-bit difference:** The binary representation of the new number differs from the previous number by **exactly one bit**. 

### **Approach**  
1. Start DFS from **0**, initializing an empty sequence.  
2. At each step, try flipping **exactly one bit** of the current number to generate potential next numbers.  
3. If a generated number satisfies the **two conditions** above, add it to the sequence and recurse.  
4. Stop the search when:
   - No valid numbers remain.
   - The sequence reaches the required length of **\(2^n\) numbers**, where \( n \) is the total number of bits.  

### **Termination Condition**  
- The sequence must contain exactly **\(2^n\) unique numbers**, ensuring a **complete Gray Code cycle**.  
- If the sequence is successfully built, return it; otherwise, backtrack and explore alternative paths.  

### Bitmask and Bit Flipping with XOR (`^`)

The **bitmask (`1 << i`)** and **XOR (`^`) operation** are both essential components of the **recursive backtracking approach**.

To derive the next number in the Gray Code sequence we apply **bitwise XOR (`^`)** with a **shifted bitmask (`1 << i`)**. 

- The **bitmask** isolates the `i`th bit
- **XOR** toggles that bit while keeping all other bits unchanged, ensuring each transition differs by exactly **one bit** from the previous number.

1. **Bitmask (`1 << i`)**  
   - This generates a mask with only the `i`th bit set, allowing **precise bit toggling**.  
   - This ensures that only **one bit changes** in each transition, which is a fundamental property of Gray Code sequences.  

2. **XOR (`^`) for Bit Flipping**  
   - The `current ^ (1 << i)` flips the `i`th bit while keeping all other bits unchanged.  
   - This allows the recursive function to **explore the next possible number** while ensuring it differs by exactly **one bit** from the previous number.  

3. **Backtracking Integration**  
   - When a number is **not in `visited`**, it is added to the sequence and the recursive call (`grayCodeAuxiliary(next)`) explores further.  
   - If no valid sequence is found, **backtracking removes the last number**, reverting to an earlier state before continuing the search.  
   - The combination of bitwise toggling, **recursive depth-first search (DFS)**, and **backtracking ensures all valid sequences are explored efficiently**.  

## **Algorithm**

### **Outline**

1. **Initialize** the sequence with **0**.
2. Use **Depth-First Search (DFS)** to explore numbers that differ by **one bit** from the current number.
3. Maintain a **set** to track visited numbers and ensure uniqueness.
4. Recursively add valid numbers to the sequence, backtracking when necessary.
5. Stop when the sequence reaches a length of **\(2^n\)**.

### **Algorithm Steps**  

1. **Initialize** a result list to store the sequence. Start with **0**, as all Gray Code sequences begin with **0**.  
2. **Initialize a set** (`visited`) to track used numbers, preventing repetition.  
3. Begin with **0** as the starting number.  
4. Implement an **auxiliary function** (`grayCodeAuxiliary`) that:  
   - Iterates over **n** bits, toggling each bit individually to generate a possible next number.  
   - Ensures the new number differs by **exactly one bit** from the previous number.  
   - Adds the new number to the sequence if it's **not in the visited set** (`visited`).  
5. **Recursive search:**  
   - Call `grayCodeAuxiliary(next)`. If it returns `true`, the valid sequence is found, enabling **early stopping** for efficiency.  
   - If no valid sequence is found, **backtrack** by removing the last added number from both the result list and the visited set.  
6. **Base condition:** Once the sequence length reaches **\(2^n\)**, return `true`.  
7. If no valid sequence is found within the loop, return `false`.

### **Pseudocode**

```plaintext
FUNCTION generateGrayCode(n):
    total_length = 2^n
    sequence = [0]  // Initialize with 0
    visited = {0}    // Track visited numbers

    FUNCTION grayCodeAuxiliary(current):
        IF length(sequence) == total_length:
            RETURN True  // Successfully found a valid sequence
        
        FOR bit FROM 0 TO n-1:  // Try flipping each bit
            next_number = current WITH (bit toggled)  // Flip bit manually
            
            IF next_number NOT IN visited:
                sequence.append(next_number)
                visited.add(next_number)
                
                IF grayCodeAuxiliary(next_number):  // Recursive call
                    RETURN True  // Early stop if sequence is completed
                
                // Backtrack
                sequence.pop()
                visited.remove(next_number)
        
        RETURN False  // No valid extension found

    grayCodeAuxiliary(0)  // Start DFS from 0
    RETURN sequence  // Return valid Gray Code sequence
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {
  public List<Integer> grayCode(int n) {
    int totalLength = 1 << n; // 2^n
    List<Integer> sequence = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();

    // Initialize the sequence with 0
    sequence.add(0);
    visited.add(0);

    // Start recursive search
    backtrack(n, totalLength, sequence, visited);

    return sequence;
  }

  private boolean backtrack(int n, int totalLength, List<Integer> sequence, Set<Integer> visited) {
    if (sequence.size() == (totalLength)) {
      return true; // Valid sequence found
    }

    int current = sequence.get(sequence.size() - 1);
    for (int i = 0; i < n; i++) {
      int next = current ^ (1 << i); // Flip ith bit

      if (!visited.contains(next)) {
        sequence.add(next);
        visited.add(next);

        if (backtrack(n, totalLength, sequence, visited)) {
          return true; // Early stop if sequence is completed
        }

        // Backtrack
        sequence.remove(sequence.size() - 1);
        visited.remove(next);
      }
    }
    return false; // No valid extension found
  }
}
```

### TypeScript

```typescript
/**
 * Generates the n-bit Gray Code sequence using recursive backtracking.
 * Each number in the sequence differs by exactly one bit from the previous number.
 *
 * @param {number} n - The number of bits in the Gray Code sequence.
 * @returns {number[]} The Gray Code sequence in decimal representation.
 */
function grayCode(n: number): number[] {
  // Compute total sequence length (2^n)
  const totalLength = 1 << n;

  // Initialize sequence with 0, as Gray Code always starts from zero
  const sequence: number[] = [0];

  // Maintain a set of visited numbers to ensure each step is unique
  const visited = new Set<number>();
  visited.add(0);

  /**
   * Performs recursive backtracking to construct the Gray Code sequence.
   * Iterates through n bits, toggling each bit to generate valid transitions.
   *
   * @returns {boolean} True if a complete Gray Code sequence is found, false otherwise.
   */
  function backtrack(): boolean {
    // Base case: Stop when the sequence reaches the required length
    if (sequence.length === totalLength) {
      return true; // Successfully generated the full sequence
    }

    // Get the last number in the sequence to determine the next step
    const current = sequence[sequence.length - 1];

    for (let i = 0; i < n; i++) {
      // Flip the ith bit using XOR and left shift to generate the next number
      const next = current ^ (1 << i);

      if (!visited.has(next)) {
        // Add the newly generated number to the sequence and track it
        sequence.push(next);
        visited.add(next);

        // Recursively attempt to build the sequence
        if (backtrack()) {
          return true; // Stop if a valid sequence is found
        }

        // Backtrack: Remove last added number and restore state
        sequence.pop();
        visited.delete(next);
      }
    }
    return false; // No valid sequence found
  }

  backtrack();
  return sequence;
}
```

## **Complexity Analysis**  

### **Assumptions**  
1. **Sequence Length:** The Gray Code sequence consists of exactly **\(2^n\)** numbers, ranging from **0 to \(2^n - 1\)**.  
2. **Bitwise Operations:** Each number differs by **exactly one bit** from the previous number, ensuring valid transitions.  
3. **Set Operations:** We use a **HashSet** (`visited`), which supports **\(O(1)\) amortized time** for insertions and lookups.  
4. **Backtracking Efficiency:** Though the algorithm theoretically explores multiple paths, it **never backtracks in practice**, always finding a valid path forward.  

### **Time Complexity: \( O(n \cdot 2^n) \)**  
- The recursion depth reaches at most **\(2^n\)** since we generate a full sequence of length **\(2^n\)**.  
- At each recursive call, we **iterate over \(n\) bits**, flipping one bit at a time.  
- Since each step processes **\(n\) bits** for **\(2^n\)** elements, the worst-case complexity is **\(O(n \cdot 2^n)\)**.  

### **Space Complexity: \( O(2^n) \)**  
- **Set Usage:** The `visited` set stores at most **\(2^n\)** elements, leading to **\(O(2^n)\) space usage**.  
- **Recursion Stack:** The depth of recursion reaches **\(2^n\)** calls, contributing to space complexity.  
- **Output Storage:** The result list also holds **\(2^n\)** numbers, but this is typically excluded from space complexity analysis.  

# Iterative Approach

## **Intuition**

Gray Code sequences can be constructed **iteratively** by leveraging the sequence of **\(G(n-1)\)** to generate **\(G(n)\)**. Observing the sequences for **\(n = 0\) to \(n = 3\)** reveals a clear pattern:  

- **\(G(0)\):** `[0]`  
- **\(G(1)\):** `[0, 1]`  
- **\(G(2)\):** `[00, 01, 11, 10]`  
- **\(G(3)\):** `[000, 001, 011, 010, 110, 111, 101, 100]`  

The key observation is that **\(G(n)\)** can be derived from **\(G(n-1)\)** by applying specific transformations.

### **Pattern for Constructing \(G(n)\) from \(G(n-1)\)**  

#### Example: **Constructing G(2) from G(1)**  

1. **Prepending `0` to all numbers in \( G(n-1) \):**  
   - If \( G(1) = [0, 1] \),  
   - Prepending `0` to each number produces **\( G(2a) \):**  
     ```plaintext
     [00, 01]
     ```

2. **Reversing \( G(n-1) \) and prepending `1`:**  
   - Reverse \( G(1) \):  
     ```plaintext
     [1, 0]
     ```
   - Prepend `1` to each number, forming **\( G(2b) \):**  
     ```plaintext
     [11, 10]
     ```

3. **Concatenating \( G(2a) \) and \( G(2b) \) to form \( G(n) \):**  
   ```plaintext
   [00, 01, 11, 10]
  ```

#### Example: **Constructing G(3) from G(2)**  

1. **Prepending `0` to all numbers in \(G(n-1)\)**:  
   - If \(G(2) = [00, 01, 11, 10]\),  
   - Prepending `0` to each number produces **\(G(3a)\)**:  
     ```plaintext
     [000, 001, 011, 010]
     ```

2. **Reversing \(G(n-1)\) and prepending `1`**:  
   - Reverse \(G(2)\):  
     ```plaintext
     [10, 11, 01, 00]
     ```
   - Prepend `1` to each number, forming **\(G(3b)\)**:  
     ```plaintext
     [110, 111, 101, 100]
     ```

3. **Concatenating \(G(3a)\) and \(G(3b)\) to form \(G(n)\)**:  
   ```plaintext
   [000, 001, 011, 010, 110, 111, 101, 100]
   ```

### **Iterative Construction Method**  
Instead of using recursion, the iterative approach **builds the sequence** using two loops:  
1. **Compute \(G(n-1)\)** first.  
2. **Prepend `0` to all numbers of \(G(n-1)\)**.  
3. **Reverse \(G(n-1)\) and prepend `1` to all numbers of the reversed sequence**.  
4. **Combine both sequences to obtain \(G(n)\)**.

This iterative method **efficiently constructs Gray Code sequences** by **modifying and merging previous sequences**.

## **Algorithm**

1. **Initialize** an empty list `result` and add `0` to it, as all Gray code sequences start with `0`.  

2. **Iterate from `i = 1` to `n`** to construct the sequence **\( G(i) \)** using **\( G(i-1) \)**.  
   - Define a **mask** by setting the `(i-1)`th bit.  
   - This mask ensures new numbers have the correct **bit shift** applied.  

3. **Reverse iterate** over `result`, applying the mask:  
   - Append each reversed number **OR-ed** (`|`) with the mask to `result`.  
   - This step ensures the required mirrored pattern for Gray code is maintained.  

4. **Return `result`**, containing the full **\( 2^n \)** Gray code sequence in decimal form.  

#### **Key Details**
- **Mask Definition:** `mask = 1 << (i - 1)` (Shifts `1` left by `(i-1)`, setting the appropriate bit).  
- **Reverse Traversal:** Ensures proper mirroring before concatenation.  
- **Bitwise Operations (`|`):** Efficiently sets the required bit.  

### **Pseudocode**

```plaintext
FUNCTION generateGrayCode(n):
  result = [0]  // Initialize sequence with 0

  FOR i FROM 1 TO n:
    mask = 1 << (i - 1)  // Set the (i-1)th bit using bit shift

    // Reverse iterate over current sequence and apply mask
    FOR j FROM length(result) - 1 DOWN TO 0:
      result.append(result[j] OR mask)  // Add prefix 1 to mirrored numbers

  RETURN result  // Final Gray Code sequence in decimal form
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

/**
 * Generates the n-bit Gray Code sequence iteratively.
 * The sequence ensures that consecutive values differ by exactly one bit.
 *
 * @param n The number of bits in the Gray Code sequence.
 * @return A list containing the Gray Code sequence in decimal form.
 */
class Solution {
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    result.add(0); // Initialize sequence with 0

    /**
     * Iteratively constructs the Gray Code sequence.
     * Each iteration mirrors and prepends a bit to extend the sequence.
     */
    for (int i = 1; i <= n; i++) {
      int mask = 1 << (i - 1); // Define mask by shifting (i-1)th bit

      // Reverse iterate over current sequence and apply mask to mirror values
      for (int j = result.size() - 1; j >= 0; j--) {
        result.add(result.get(j) | mask); // Prepend 1 to mirrored numbers
      }
    }

    return result; // Return final Gray Code sequence in decimal form
  }
}
```

### TypeScript

```ts
function grayCode(n: number): number[] {
  const result: number[] = [0]; // Initialize sequence with 0

  /**
   * Iteratively constructs the Gray Code sequence.
   * Each iteration mirrors the sequence and applies bitwise shifts.
   */
  for (let i = 0; i < n; i++) {
    const mask = 1 << i; // Create mask by shifting bit i

    // Reverse iterate over current sequence and apply mask
    // Ensures mirrored extension where higher-bit numbers are added
    for (let j = result.length - 1; j >= 0; j--) {
      result.push(result[j] | mask); // Prepend 1 to mirrored values
    }
  }

  return result; // Final Gray Code sequence in decimal form
}
```

## **Complexity Analysis**  

### **Assumptions**  
- The algorithm constructs a **Gray Code sequence iteratively**, expanding from \( G(n-1) \) to \( G(n) \).  
- The sequence follows a **mirroring pattern**, where the number of elements doubles at each step.  
- Bitwise operations (`<<`, `|`) and array operations (`push`, `reverse iteration`) are **constant time** \( O(1) \).  

### **Time Complexity**: **\( O(2^n) \)**  
- The sequence starts with `1` element (`G(0) = [0]`).  
- At each step, the number of elements **doubles**, forming a sequence of **\( 2^n \) elements** in total.  
- The iteration **processes each previous sequence element**, requiring **\( O(2^n) \)** operations cumulatively.  
- **Bitwise operations (`|`) and array access (`push`)** run in **\( O(1) \)** per step.  
- **Total complexity:** Since every level doubles the previous iteration, the time complexity is **exponential**:  
  \[
  O(2^n)
  \]

### **Space Complexity**: **\( O(2^n) \)**  
- **Constant-Space Usage**: Set and auxiliary variables (`mask`, loop counters) use **constant space** \( O(1) \).  
- **No Additional Structures**: are used beyond storing the sequence itself.  

# Optimized Iterative Approach

### Overview

In the intuition we will arive arrive to these conclusions:

- **Every consecutive number differs by one bit**
- **All numbers in the sequence are unique**
- **Each Gray Code value is unique** and **never repeats**.
- `G(i) = i ^ (i >> 1)`, allows us to compute Gray Code values in **constant time `O(1)`**.

#### Figure 2 - A table displaying indices 0 to 10, their corresponding Gray Code values `G(i)`, and the XOR result of the index with its Gray Code (`i ^ G(i)`)

![Figure 2 - A table displaying indices 0 to 10, their corresponding Gray Code values `G(i)`, and the XOR result of the index with its Gray Code (`i ^ G(i)`)](img/89-2.jpg)

## **Intuition**

Many problems can be solved more efficiently by recognizing **patterns** that relate input values to expected output values. In this case, solving the Gray Code problem using an **intuitive** approach first helps us derive the expected sequence. Once we observe a **consistent pattern**, we can formulate a more optimized solution.

By analyzing the table in the overview, we can **identify the relationship** between index `i` and its Gray Code value `G(i)`. This pattern is difficult to recognize at first, but taking the **XOR of `i` and `G(i)`** reveals a useful relationship.

## **Key Observation**
Consider **Figure 2**, which displays indices `0-10`, their corresponding Gray Code values `G(i)`, and the XOR product of the index with its Gray Code (`i ^ G(i)`).

### **Figure 2 - Index to Gray Code Relationship**
![Figure 2 - Index to Gray Code Relationship](img/89-2.jpg)

Examining the table, we notice that:

```plaintext
i ^ G(i) = i / 2
```

where `^` signifies XOR and `/` represents **integer (floor) division**.

### **Formula Derivation**
Rearranging the equation, we derive a **direct formula** to compute Gray Code values:

```plaintext
G(i) = i ^ (i / 2)
```
or equivalently,
```plaintext
G(i) = i ^ (i >> 1)
```

If this pattern **always holds**, we can compute each Gray Code value in **constant time `O(1)`** without iterating over previous sequences.

### **Proof of Correctness**
To validate this formula, we must prove two properties:

#### **1. Consecutive Numbers Differ by Exactly One Bit**
Gray Code sequences require each consecutive number to differ by only **one bit**. We verify this by proving:

```plaintext
G(i) ^ G(i + 1) = (i ^ (i >> 1)) ^ ((i + 1) ^ ((i + 1) >> 1))
```

Rewriting using the **commutative property of XOR**:

```plaintext
= (i ^ (i >> 1)) ^ (i + 1) ^ ((i + 1) >> 1)
= (i ^ (i + 1)) ^ ((i ^ (i + 1)) >> 1)
```

Denoting:

```plaintext
X = (i ^ (i + 1))
Y = ((i ^ (i + 1)) >> 1)
```

Observing binary changes:

- Adding `1` to a number **toggles every bit** from the rightmost `0` bit onward.
- Example: `87 + 1 = 88 → 1010111 + 0000001 = 1011000`
  - Bits `0-3` flip, while higher bits remain unchanged.
- Thus, in **general**:
  - If `i = ...#01...1`, then `i + 1 = ...#10...0` (where `#` marks the **first bit to the left** of the rightmost `0`).
  - The trailing bits **flip**, ensuring `G(i) ^ G(i + 1)` **always differs in exactly one bit**.

Using XOR:

```plaintext
X = i ^ (i + 1) = 0000000111111
Y = (i ^ (i + 1)) >> 1 = 0000000011111
X ^ Y = 0000000100000
```

Thus, **consecutive Gray Code values differ by exactly one bit**, ensuring correctness.

#### **2. Uniqueness - No Number is Repeated**
We must ensure `G(i)` is **bijective**, meaning `G(i) = G(j)` if and only if `i = j`.

Using:

```plaintext
G(i) = i ^ (i >> 1)
G(j) = j ^ (j >> 1)
```

If `G(i) = G(j)`, then:

```plaintext
G(i) ^ G(j) = (i ^ j) ^ ((i ^ j) >> 1)
```

Denoting:

```plaintext
X = i ^ j
```

Binary analysis:

- If `X` consists only of `0`s:
  ```plaintext
  X = bn-1bn-2...b0 = 0
  ```
- Then:
  ```plaintext
  X >> 1 = 0bn-1bn-2...b1
  ```
- Since XORing `X` with `X >> 1` must be `0`:
  ```plaintext
  X ^ (X >> 1) = 0
  ```

Bitwise comparison confirms:

```plaintext
bn-1 ^ 0 = 0 → bn-1 = 0
bn-3 ^ bn-2 = 0 → bn-3 = 0
b0 ^ b1 = 0 → b0 = 0
```

Thus,

```plaintext
i ^ j = 0 → i = j
```

Meaning **each Gray Code value is unique** and **never repeats**.

### **Conclusion**
By proving:
- **Every consecutive number differs by one bit**
- **All numbers in the sequence are unique**

We confirm the **correctness** of `G(i) = i ^ (i >> 1)`, allowing us to compute Gray Code values in **constant time `O(1)`**.

## **Algorithm**

1. **Initialize an empty result list** `result` and set `sequenceLength = 2^n`, where `n` is the number of bits.  
   - This ensures the correct number of Gray Code values are generated.  

2. **Iterate from `i = 0` to `sequenceLength - 1`**:  
   - Compute the Gray Code value using:  
     ```plaintext
     G(i) = i ^ (i >> 1)
     ```  
   - Append the computed value to `result`.  

3. **Return `result`**, containing the full Gray Code sequence.

### **Pseudocode**

```plaintext
FUNCTION generateGrayCode(n):
  sequenceLength ← 2^n  // Compute total number of elements
  result ← EMPTY LIST   // Initialize result list

  FOR i FROM 0 TO sequenceLength - 1:
    grayCode ← i XOR (i RIGHT_SHIFT 1)  // Compute Gray Code
    APPEND grayCode TO result           // Store in result list

  RETURN result  // Return final Gray Code sequence
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

/**
 * Generates the n-bit Gray Code sequence iteratively in a single loop.
 * The sequence ensures that consecutive values differ by exactly one bit.
 *
 * @param n The number of bits in the Gray Code sequence.
 * @return A list containing the Gray Code sequence in decimal form.
 */
class Solution {
  public List<Integer> grayCode(int n) {
    int sequenceLength = 1 << n; // Compute 2^n for the total sequence length
    List<Integer> result = new ArrayList<>(); // Initialize result list

    // Generate Gray Code sequence iteratively
    for (int i = 0; i < sequenceLength; i++) {
      result.add(i ^ (i >> 1)); // Compute Gray Code using XOR pattern
    }

    return result; // Return final sequence
  }
}
```

### TypeScript
```ts
function grayCode(n: number): number[] {
  const sequenceLength = 1 << n; // Compute 2^n for the total length
  const result: number[] = []; // Initialize result array

  for (let i = 0; i < sequenceLength; i++) {
    result.push(i ^ (i >> 1)); // Generate Gray Code and store it
  }

  return result; // Return final sequence
}
```

## **Complexity Analysis**  

### **Assumptions**  
- `n` represents the number of bits in the Gray Code sequence.  
- The algorithm **directly computes** each Gray Code value using `G(i) = i ^ (i >> 1)`.  
- No recursive calls or extra iterations over previously computed sequences are required.  

### **Time Complexity**: **`O(2^n)`**  
- The sequence contains **`2^n` elements**, as Gray Code requires **all `n-bit` numbers** in the sequence.  
- The algorithm runs **a single loop** from `i = 0` to `2^n - 1`, computing each value in **`O(1)`** time using bitwise XOR.  
- Since **each iteration computes exactly one value**, the total number of operations is **proportional to `2^n`**, resulting in a **time complexity of `O(2^n)`**.  

### **Space Complexity**: **`O(1)`**  
- **Constant auxiliary space usage**: The algorithm **only uses a few fixed variables** (`sequenceLength`, `result`, and loop counters).  
- **Gray Code sequence storage is excluded** from space complexity calculations (as per the problem constraints).  
- **No extra data structures** beyond standard loop iteration are allocated, ensuring **constant space usage**.  
- Since space **does not grow with `n`**, the space complexity remains **`O(1)`**.  