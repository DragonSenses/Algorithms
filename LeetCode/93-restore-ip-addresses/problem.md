# 93. Restore IP Addresses

<p>A <strong>valid IP address</strong> consists of exactly four integers separated by single dots. Each integer is between <code>0</code> and <code>255</code> (<strong>inclusive</strong>) and cannot have leading zeros.</p>

<ul>
  <li>For example, <code>"0.1.2.201"</code> and <code>"192.168.1.1"</code> are <strong>valid</strong> IP addresses, but <code>"0.011.255.245"</code>, <code>"192.168.1.312"</code> and <code>"192.168@1.1"</code> are <strong>invalid</strong> IP addresses.</li>
</ul>

<p>Given a string <code>s</code> containing only digits, return <em>all possible valid IP addresses that can be formed by inserting dots into </em><code>s</code>. You are <strong>not</strong> allowed to reorder or remove any digits in <code>s</code>. You may return the valid IP addresses in <strong>any</strong> order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "25525511135"
<strong>Output:</strong> ["255.255.11.135","255.255.111.35"]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "0000"
<strong>Output:</strong> ["0.0.0.0"]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "101023"
<strong>Output:</strong> ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= s.length &lt;= 20</code></li>
  <li><code>s</code> consists of digits only.</li>
</ul>

<br>

---

# Solution

- [Backtracking Approach](#backtracking-approach)
  - **Time Complexity**: `O(M^N * N)`
- [Iterative Approach](#iterative-approach)

# Backtracking Approach

## **Intuition**

### Concept
A valid IP address consists of 4 integers, meaning we need to place 3 dots. We can try placing dots at all possible different positions using backtracking. If an invalid number forms, we backtrack to try another combination.

### Backtracking
Backtracking is a general algorithmic technique that searches every possible combination to solve a computational problem. It incrementally builds candidates to the solution and abandons a candidate ("backtracks") when it determines that the candidate cannot lead to the solution.

### Approach
We will recursively enumerate all possibilities. Whenever we get a new integer because of a dot (or 2 integers for the last dot), we check whether the integer(s) is valid (i.e., the integer cannot have leading zeros, other than being 0 itself, and it's no larger than 255).

### Possibilities
There are 3 possibilities to add each dot: it can be added after 1, 2, or 3 digits from the last dot or the beginning of the string, so there are at most `3^3 = 27` possibilities to add all 3 dots.

### Optimization
An optimization is to return an empty result if the input string's length is longer than 12 since each integer can have at most 3 digits.

### Utility Function
We can create a utility function `validSegment(s, start, length)` to check whether the substring from `start` to `start + length` is a valid number in the range 0-255. The logic is to check both conditions (the caller guarantees that the length is in the range of [1, 3]):
1. If the substring's first character is 0 (i.e., `s[start]` is '0'), then the length must be 1.
2. If the length is 3, the substring should not be larger than "255" lexically. If the length is 1 or 2 and the first case was not triggered, then it will be in the acceptable range.

## **Algorithm**

Create a utility function, named `backtrack`, which takes the original string `s`, the processing index `startIndex` (consider the substring starting from `startIndex` where the prefix part is already separated into valid integers), a list of integers `dots` which saves the positions for the dots added so far, and a list of strings `ans` to save the answers.

### Key Steps:

#### 1. Initialization:
- Set `remainingLength` to `length of s - startIndex` which is the length of the string we want to process.
- Set `remainingNumberOfIntegers` to `4 - dots.length`. This is how many integers we have left to form.

#### 2. Validation Check:
- Return if `remainingLength` is larger than `remainingNumberOfIntegers * 3` or smaller than `remainingNumberOfIntegers`, since each integer has 1-3 digits. This catches the case where `s.length() > 12` since at the very beginning `remainingLength` is `s.length()`.

#### 3. Final Integer Check:
- If `remainingNumberOfIntegers == 1`:
  - Check if the last integer `s.substring(startIndex, startIndex + remainingLength)` is valid:
    - Create an empty string to save this answer using the following steps:
      - Set `last` to 0.
      - Iterate over all elements `dot` in the list `dots`.
      - Append `s.substring(last, last + dot)` and a '.' into the answer string.
      - Increase `last` by `dot` and repeat these steps for each dot.
      - Append `s.substring(last, s.length)` which is the final integer after the last dot.
      - Add the answer string into `ans`.
    - Return.

#### 4. Recursive Backtracking:
- Iterate over `curPos` from 1 to `min(3, remainingLength)`. `curPos` is the number of digits we are including before placing a dot.
  - Place a dot by adding `curPos` into `dots`.
  - If the integer `s.substring(startIndex, startIndex + curPos)` is valid:
    - Call the utility function recursively: `helper(s, startIndex + curPos, dots, ans)`.
  - Remove the dot that we placed to backtrack.

### Pseudocode

```plaintext
function valid_segment(s, start, length):
    if length == 1:
        return True
    if s[start] == '0':
        return False
    if length == 2:
        return 10 <= int(s[start:start + 2]) <= 99
    if length == 3:
        return 100 <= int(s[start:start + 3]) <= 255
    return False

function helper(s, startIndex, dots, ans):
    remainingLength = length(s) - startIndex
    remainingNumberOfIntegers = 4 - length(dots)
    
    if remainingLength > remainingNumberOfIntegers * 3 or remainingLength < remainingNumberOfIntegers:
        return
    
    if remainingNumberOfIntegers == 1:
        if valid_segment(s, startIndex, remainingLength):
            last = 0
            ip_address = []
            for dot in dots:
                ip_address.append(s[last:last + dot] + '.')
                last += dot
            ip_address.append(s[startIndex:])
            ans.append(''.join(ip_address))
        return
    
    for curPos in range(1, min(4, remainingLength + 1)):
        if valid_segment(s, startIndex, curPos):
            dots.append(curPos)
            helper(s, startIndex + curPos, dots, ans)
            dots.pop()

function restore_ip_addresses(s):
    ans = []
    helper(s, 0, [], ans)
    return ans
```

## **Implementation**

### Java

```java
import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), ans);
    return ans;
  }

  private static void backtrack(String s, int startIndex, List<Integer> dots, List<String> ans) {
    int remainingLength = s.length() - startIndex;
    int remainingNumberOfIntegers = 4 - dots.size();

    if (remainingLength > remainingNumberOfIntegers * 3 || remainingLength < remainingNumberOfIntegers) {
      return;
    }

    if (remainingNumberOfIntegers == 1) {
      if (validSegment(s, startIndex, remainingLength)) {
        StringBuilder ipAddress = new StringBuilder();
        int last = 0;
        for (int dot : dots) {
          ipAddress.append(s, last, last + dot).append('.');
          last += dot;
        }
        ipAddress.append(s, startIndex, s.length());
        ans.add(ipAddress.toString());
      }
      return;
    }

    for (int curPos = 1; curPos <= Math.min(3, remainingLength); curPos++) {
      if (validSegment(s, startIndex, curPos)) {
        dots.add(curPos);
        backtrack(s, startIndex + curPos, dots, ans);
        dots.remove(dots.size() - 1);
      }
    }
  }

  private static boolean validSegment(String s, int start, int length) {
    if (length == 1) {
      return true;
    }
    if (s.charAt(start) == '0') {
      return false;
    }
    if (length == 2) {
      return 10 <= Integer.parseInt(s.substring(start, start + 2))
          && Integer.parseInt(s.substring(start, start + 2)) <= 99;
    }
    if (length == 3) {
      return 100 <= Integer.parseInt(s.substring(start, start + 3))
          && Integer.parseInt(s.substring(start, start + 3)) <= 255;
    }
    return false;
  }
}
```

### TypeScript

```typescript
function restoreIpAddresses(s: string): string[] {
  const result: string[] = [];
  backtrack(s, 0, [], result);
  return result;
};

function backtrack(
  s: string,
  startIndex: number,
  dots: number[],
  result: string[]
): void {
  const remainingLength = s.length - startIndex;
  const remainingNumberOfIntegers = 4 - dots.length;

  // Check if the remaining characters can form valid segments.
  if (
    remainingLength > remainingNumberOfIntegers * 3 ||
    remainingLength < remainingNumberOfIntegers
  ) {
    return;
  }

  // If we have 1 segment left to place.
  if (remainingNumberOfIntegers === 1) {
    if (isValidSegment(s, startIndex, remainingLength)) {
      let ipAddress = "";
      let last = 0;
      // Construct the IP address from the segments.
      for (const dot of dots) {
        ipAddress += s.slice(last, last + dot) + ".";
        last += dot;
      }
      ipAddress += s.slice(startIndex);
      result.push(ipAddress);
    }
    return;
  }

  // Try placing a dot at every possible position.
  for (let curPos = 1; curPos <= Math.min(3, remainingLength); curPos++) {
    if (isValidSegment(s, startIndex, curPos)) {
      dots.push(curPos);
      backtrack(s, startIndex + curPos, dots, result);
      dots.pop();
    }
  }
}

function isValidSegment(s: string, start: number, length: number): boolean {
  if (length === 1) {
    return true;
  }
  if (s.charAt(start) === "0") {
    return false;
  }
  if (length === 2) {
    const segment = parseInt(s.slice(start, start + 2), 10);
    return segment >= 10 && segment <= 99;
  }
  if (length === 3) {
    const segment = parseInt(s.slice(start, start + 3), 10);
    return segment >= 100 && segment <= 255;
  }
  return false;
}
```

## **Complexity Analysis**

Let's assume we need to separate the input string into `N` integers, with each integer being at most `M` digits.

### **Time Complexity**: `O(M^N * N)`

#### Key Points:
- **Number of Possibilities**: There are at most `M^(N-1)` ways to place the dots.
- **Validation Time**: Checking whether all parts are valid takes `O(M * N)` time for each possibility.

#### Analysis:
1. **Number of Possibilities**:
   - There are `M^(N-1)` ways to place the dots since each of the `(N-1)` positions can have `M` different options for placing a dot.

2. **Validation**:
   - For each combination, we need to check if each part is valid, which takes `O(M * N)` time.

3. **Final Complexity**:
   - The total time complexity is given by multiplying the number of possibilities with the time taken for validation: `O(M^(N-1) * (M * N))`.
   - Simplifying this, we get: `O(M^(N-1) * M * N) = O(M^N * N)`.

For this question, `M = 3` and `N = 4`, so the time complexity is `O(3^3 * 4) = O(27 * 4) = O(108)` which simplifies to `O(1)` as it is constant for small, fixed values of `M` and `N`.

### **Space Complexity**: `O(M * N)`

#### Key Points:
- **Storing Dots**: For each possibility, we store `(N - 1)` numbers, representing the positions of the dots.
- **Temporary Storage**: We need temporary space to store a solution string before adding it to the answer list.

#### Analysis:
1. **Storing Dot Positions**:
   - We store `(N - 1)` numbers, each representing the position of a dot, taking `O(N)` space.

2. **Temporary Storage**:
   - The length of each solution string is `M * N + M - 1 = O(M * N)`, since each integer has up to `M` digits, and we need `(M - 1)` dots.
   - The total space complexity for storing the solution string is `O(M * N)`.

3. **Final Complexity**:
   - Adding these up, the total space complexity, excluding the output space, is `O(N) + O(M * N) = O(M * N)`.

For this question, `M = 3` and `N = 4`, so the space complexity is also `O(1)` for small, fixed values of `M` and `N`.

# Iterative Approach

## **Intuition**

To restore IP addresses from a given string, we need to split it into 4 parts, each representing a valid integer between 0 and 255. We can achieve this by iterating over the possible lengths of the first three parts (`len1`, `len2`, `len3`) and ensuring the fourth part is the remainder of the string.

### Length Ranges:
1. **`len1`**: The length of the first part should be in the range `[ max(1, s.length() - 9), min(3, s.length() - 3) ]`. This ensures there are enough characters left for the other three parts.
2. **`len2`**: The length of the second part should be in the range `[ max(1, s.length() - len1 - 6), min(3, s.length() - len1 - 2) ]`. This ensures there are enough characters left for the remaining two parts.
3. **`len3`**: The length of the third part should be in the range `[ max(1, s.length() - len1 - len2 - 3), min(3, s.length() - len1 - len2 - 1) ]`. This ensures the last part is of valid length.

By doing so, the length of the fourth part will always be in the valid range `[1, 3]`. We can then validate each part as we form them, preventing any invalid segments from being considered.

## **Algorithm**

1. **Initialize Result List**: Start with an empty list to store valid IP addresses.
2. **Iterate Over `len1`**:
   - Determine valid ranges for the first part.
   - If the first part is valid, proceed to the next step.
3. **Iterate Over `len2`**:
   - Determine valid ranges for the second part within the remaining string.
   - If the second part is valid, proceed to the next step.
4. **Iterate Over `len3`**:
   - Determine valid ranges for the third part within the remaining string.
   - If the third part is valid, check the fourth part.
5. **Validate and Concatenate**:
   - If all four parts are valid, concatenate them with dots in between and add the resulting IP address to the result list.
6. **Return Result**: After iterating through all possible combinations, return the list of valid IP addresses.

### Pseudocode

```plaintext
function restoreIpAddresses(s):
    result = []
    
    for len1 in range(max(1, s.length - 9), min(3, s.length - 3) + 1):
        part1 = substring(s, 0, len1)
        if not isValidSegment(part1):
            continue
            
        for len2 in range(max(1, s.length - len1 - 6), min(3, s.length - len1 - 2) + 1):
            part2 = substring(s, len1, len1 + len2)
            if not isValidSegment(part2):
                continue
                
            for len3 in range(max(1, s.length - len1 - len2 - 3), min(3, s.length - len1 - len2 - 1) + 1):
                part3 = substring(s, len1 + len2, len1 + len2 + len3)
                part4 = substring(s, len1 + len2 + len3)
                
                if isValidSegment(part3) and isValidSegment(part4):
                    result.append(part1 + "." + part2 + "." + part3 + "." + part4)
                    
    return result

function isValidSegment(segment):
    if segment is empty or segment.length > 3:
        return false
    if segment[0] == '0' and segment.length > 1:
        return false
    if int(segment) < 0 or int(segment) > 255:
        return false
    return true
```

## **Implementation**

```java
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
  public static List<String> restoreIpAddresses(String s) {
    List<String> result = new ArrayList<>();

    int len = s.length();
    for (int len1 = Math.max(1, len - 9); len1 <= Math.min(3, len - 3); len1++) {
      String part1 = s.substring(0, len1);
      if (!isValidSegment(part1))
        continue;

      for (int len2 = Math.max(1, len - len1 - 6); len2 <= Math.min(3, len - len1 - 2); len2++) {
        String part2 = s.substring(len1, len1 + len2);
        if (!isValidSegment(part2))
          continue;

        for (int len3 = Math.max(1, len - len1 - len2 - 3); len3 <= Math.min(3, len - len1 - len2 - 1); len3++) {
          String part3 = s.substring(len1 + len2, len1 + len2 + len3);
          String part4 = s.substring(len1 + len2 + len3);

          if (isValidSegment(part3) && isValidSegment(part4)) {
            result.add(part1 + "." + part2 + "." + part3 + "." + part4);
          }
        }
      }
    }

    return result;
  }

  private static boolean isValidSegment(String segment) {
    if (segment.isEmpty() || segment.length() > 3)
      return false;
    if (segment.charAt(0) == '0' && segment.length() > 1)
      return false;
    int value = Integer.parseInt(segment);
    return value >= 0 && value <= 255;
  }
}
```

### TypeScript

```typescript
function restoreIpAddresses(s: string): string[] {
  const result: string[] = [];
  const len = s.length;

  for (let len1 = Math.max(1, len - 9); len1 <= Math.min(3, len - 3); len1++) {
    const part1 = s.slice(0, len1);
    if (!isValidSegment(part1)) continue;

    for (
      let len2 = Math.max(1, len - len1 - 6);
      len2 <= Math.min(3, len - len1 - 2);
      len2++
    ) {
      const part2 = s.slice(len1, len1 + len2);
      if (!isValidSegment(part2)) continue;

      for (
        let len3 = Math.max(1, len - len1 - len2 - 3);
        len3 <= Math.min(3, len - len1 - len2 - 1);
        len3++
      ) {
        const part3 = s.slice(len1 + len2, len1 + len2 + len3);
        const part4 = s.slice(len1 + len2 + len3);

        if (isValidSegment(part3) && isValidSegment(part4)) {
          result.push(`${part1}.${part2}.${part3}.${part4}`);
        }
      }
    }
  }

  return result;
}

function isValidSegment(segment: string): boolean {
  if (segment.length === 0 || segment.length > 3) return false;
  if (segment[0] === "0" && segment.length > 1) return false;
  const value = parseInt(segment, 10);
  return value >= 0 && value <= 255;
}
```


### **Time Complexity**: `O(M^N * N)`

1. **Iterative Loops**: We have `N-1` nested loops, each ranging from 1 to 3. Thus, there are at most `3^(N-1)` iterations.
2. **Validation of Each Segment**: For each combination of segments, we validate each segment to ensure it is a valid part of an IP address. This involves checking the length and value of each segment, which takes constant time `O(1)` for each segment.
3. **Concatenation of Segments**: For each valid combination, we concatenate the segments to form an IP address, which takes `O(N)` time.

Combining these factors, the overall time complexity is `O(3^(N-1) * N)` which simplifies to `O(M^N * N)` since `M` is a constant upper bound for segment length.
