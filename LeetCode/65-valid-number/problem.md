# 65. Valid Number

<p>Given a string <code>s</code>, return whether <code>s</code> is a <strong>valid number</strong>.<br>
<br>
For example, all the following are valid numbers: <code>"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"</code>, while the following are not valid numbers: <code>"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"</code>.</p>

<p>Formally, a&nbsp;<strong>valid number</strong> is defined using one of the following definitions:</p>

<ol>
  <li>An <strong>integer number</strong> followed by an <strong>optional exponent</strong>.</li>
  <li>A <strong>decimal number</strong> followed by an <strong>optional exponent</strong>.</li>
</ol>

<p>An <strong>integer number</strong> is defined with an <strong>optional sign</strong> <code>'-'</code> or <code>'+'</code> followed by <strong>digits</strong>.</p>

<p>A <strong>decimal number</strong> is defined with an <strong>optional sign</strong> <code>'-'</code> or <code>'+'</code> followed by one of the following definitions:</p>

<ol>
  <li><strong>Digits</strong> followed by a <strong>dot</strong> <code>'.'</code>.</li>
  <li><strong>Digits</strong> followed by a <strong>dot</strong> <code>'.'</code> followed by <strong>digits</strong>.</li>
  <li>A <strong>dot</strong> <code>'.'</code> followed by <strong>digits</strong>.</li>
</ol>

<p>An <strong>exponent</strong> is defined with an <strong>exponent notation</strong> <code>'e'</code> or <code>'E'</code> followed by an <strong>integer number</strong>.</p>

<p>The <strong>digits</strong> are defined as one or more digits.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "0"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "e"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "."</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
  <li><code>1 &lt;= s.length &lt;= 20</code></li>
  <li><code>s</code> consists of only English letters (both uppercase and lowercase), digits (<code>0-9</code>), plus <code>'+'</code>, minus <code>'-'</code>, or dot <code>'.'</code>.</li>
</ul>

---

# Solution

- [Rule-Based Validation Approach](#rule-based-validation-approach)
  - **Time Complexity**: `O(n)`
  - **Space Complexity**: `O(1)`

### Problem Overview: Valid Number

The task is to determine if a given string represents a valid number. A valid number can be an integer or a decimal number, with or without an optional exponent.

### Key Definitions

1. **Integer Number**:
   - May have an **optional sign** (`'+'` or `'-'`).
   - Must consist of one or more **digits**.
   - Can be followed by an **optional exponent**.

2. **Decimal Number**:
   - May have an **optional sign** (`'+'` or `'-'`).
   - Must satisfy one of the following formats:
     - **Digits**, followed by a **dot** (`'.'`).
     - **Digits**, followed by a **dot** (`'.'`), and then more **digits**.
     - A **dot** (`'.'`), followed by **digits**.
   - Can also be followed by an **optional exponent**.

3. **Exponent**:
   - Denoted by **'e'** or **'E'**.
   - Must be followed by a valid **integer number**, which itself may have an **optional sign**.

4. **Valid Digits**:
   - A sequence of one or more characters from `0` to `9`.

### Input Examples

- **Valid Strings**: `"2"`, `"0089"`, `"-0.1"`, `"+3.14"`, `"4."`, `"-123.456e789"`.
- **Invalid Strings**: `"abc"`, `"1a"`, `"e3"`, `"--6"`, `"99e2.5"`, `"-+3"`.

### Constraints

- Length of `s` is between **1** and **20**.
- `s` can include:
  - **Digits** (`0-9`).
  - Signs (`'+'` or `'-'`).
  - Decimal point (`'.'`).
  - Exponent notation (`'e'` or `'E'`).
  - English letters (both uppercase and lowercase).

### Validation Strategy

1. **Parse Components**:
   - Separate the string into its parts: sign, digits, decimal point, and exponent.
   - Ensure each part conforms to its respective definition.

2. **Format Checks**:
   - Handle edge cases with misplaced or duplicate characters, like multiple signs or misplaced dots.

3. **Edge Cases**:
   - Strings containing letters outside of valid exponents.
   - Numbers with incomplete or improper exponents, e.g., `"1e"` or `"e3"`.

### Algorithm Outline

To validate the input:
1. Check for formatting issues:
   - Misplaced signs, dots, or exponent notations.
   - Presence of invalid characters.
2. Implement a parsing mechanism to verify integer/decimal structure and optional exponent.
3. Consider edge cases to prevent false positives (e.g., `"1e."` or `"++1"`).

# Rule-Based Validation Approach

This rule-based approach provides a systematic way to validate the input string, ensuring compliance with the specified rules. Each rule acts as a logical filter, progressively confirming or rejecting the validity of the input.

## **Intuition**
The problem is defined by a clear set of rules. The strategy here is to break the characters into logical groups, define rules for each group, and validate the input string against these rules as we iterate through it. This ensures that each component aligns with the format of a valid number.

#### **Character Groups and Observations**
1. **Digits** (`0-9`):
   - Both **decimal numbers** and **integers** must contain at least one digit.

2. **Sign** (`+` or `-`):
   - A sign is optional for both decimal numbers and integers.
   - If present, it must either be:
     - The **first character** of the number, or
     - Immediately after an exponent (`e` or `E`).

3. **Exponent** (`e` or `E`):
   - Optional in a valid number.
   - If included, it must:
     - Appear **after** a decimal number or an integer.
     - Be followed by a valid **integer**.

4. **Dot** (`.`):
   - A decimal number can only contain **one** dot.
   - Integers **cannot** contain dots.
   - Dots cannot appear **after an exponent**, since exponents only allow integers.

5. **Invalid Characters** (anything else):
   - Any other character immediately invalidates the number.

#### **Rules for Validation**
1. **Digits**:
   - At least one digit must be present in the input. Use a variable (`seenDigit`) to track whether a digit has been encountered.

2. **Signs**:
   - Signs can appear only:
     - As the **first character**.
     - Immediately following an exponent.
   - Any other position for a sign makes the number invalid.

3. **Exponents** (`e` or `E`):
   - There can be **at most one** exponent. Use a variable (`seenExponent`) to track this.
   - Exponents must follow a valid decimal number or integer. If no digit is seen before an exponent, the input is invalid.
   - The exponent must be followed by a valid integer.

4. **Dots** (`.`):
   - At most **one dot** is allowed. Use a variable (`seenDot`) to track this.
   - Dots cannot appear after an exponent. If a dot is found after an exponent, the input is invalid.

5. **Other Characters**:
   - Encountering anything outside of these groups (digits, signs, exponents, dots) instantly invalidates the input.

## **Algorithm**

This algorithm iteratively validates the input string by examining each character, determining its type (digit, sign, exponent, dot, or invalid), and ensuring it adheres to the rules outlined previously. It uses flags to track key states during the iteration, providing a logical framework for evaluating validity.

#### **Step-by-Step Procedure**

1. **Initialization**:
   - Declare three boolean variables:
     - `seenDigit`: Tracks if at least one valid digit has been encountered.
     - `seenExponent`: Tracks if an exponent (`e` or `E`) has been encountered.
     - `seenDot`: Tracks if a dot (`.`) has been encountered.

2. **Iteration**:
   - Traverse the input string character by character.

3. **Digit Check**:
   - If the current character is a digit, set `seenDigit = true` to indicate that a valid digit exists in the input.

4. **Sign Check**:
   - If the current character is a sign (`+` or `-`), ensure it is either:
     - The **first character** in the input.
     - Immediately following an exponent (`e` or `E`).
   - If neither condition is true, return `false` as the input is invalid.

5. **Exponent Check**:
   - If the current character is an exponent (`e` or `E`):
     - Check if an exponent has already been encountered (`seenExponent == true`). If so, return `false`.
     - Check if no digit has been seen yet (`seenDigit == false`). If so, return `false`.
     - Otherwise, set `seenExponent = true` to mark the presence of an exponent, and reset `seenDigit = false` since a valid integer must follow the exponent.

6. **Dot Check**:
   - If the current character is a dot (`.`):
     - Ensure that no other dot has been encountered (`seenDot == false`) and no exponent has been encountered (`seenExponent == false`).
     - If either condition fails, return `false`.
     - Otherwise, set `seenDot = true`.

7. **Invalid Characters**:
   - If any other character is encountered (not a digit, sign, exponent, or dot), return `false` as the input is invalid.

8. **Final Validation**:
   - After completing the iteration, return the value of `seenDigit`. This ensures that the input contains at least one digit and adheres to the rules.

#### **Key Design Insights**
- **State Tracking**:
  - Boolean flags (`seenDigit`, `seenExponent`, `seenDot`) enable dynamic validation during traversal, ensuring compliance with rules in real-time.
- **Resetting State**:
  - Resetting `seenDigit` after encountering an exponent ensures that the algorithm correctly validates the new integer following the exponent.

### **Pseudocode**

```plaintext
FUNCTION isValidNumber(inputString)
    INITIALIZE seenDigit AS false
    INITIALIZE seenExponent AS false
    INITIALIZE seenDot AS false

    FOR each character IN inputString
        IF character IS a digit
            SET seenDigit = true
        
        ELSE IF character IS '+' OR '-'
            IF NOT (character IS first OR previous character IS 'e' OR 'E')
                RETURN false
        
        ELSE IF character IS 'e' OR 'E'
            IF seenExponent IS true OR seenDigit IS false
                RETURN false
            SET seenExponent = true
            SET seenDigit = false
        
        ELSE IF character IS '.'
            IF seenDot IS true OR seenExponent IS true
                RETURN false
            SET seenDot = true
        
        ELSE
            RETURN false
    END FOR

    RETURN seenDigit
END FUNCTION
```

## **Implementation**

### Java

```java
class Solution {
  public boolean isNumber(String s) {
    boolean seenDigit = false; // To track if any digit has been encountered
    boolean seenExponent = false; // To track if an exponent has been encountered
    boolean seenDot = false; // To track if a dot has been encountered

    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);

      if (Character.isDigit(curr)) {
        // A digit is valid, mark it as seen
        seenDigit = true;
      } else if (curr == '+' || curr == '-') {
        // A sign is valid only at the start or immediately after an exponent
        if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
          return false;
        }
      } else if (curr == 'e' || curr == 'E') {
        // An exponent is valid only if one hasn't been seen already and digits exist before it
        if (seenExponent || !seenDigit) {
          return false;
        }
        seenExponent = true;
        seenDigit = false; // Reset digit tracking for the integer part after the exponent
      } else if (curr == '.') {
        // A dot is valid only if one hasn't been seen already and it appears before an exponent
        if (seenDot || seenExponent) {
          return false;
        }
        seenDot = true;
      } else {
        // Any character outside valid ones makes the string invalid
        return false;
      }
    }

    // At the end, ensure that at least one digit was seen
    return seenDigit;
  }
}
```

## **Complexity Analysis**

### **Assumptions**
- Let `n` represent the length of the input string `s`.
- Each character in the string is accessed and processed individually in a single pass.
- The algorithm uses a small, constant number of boolean variables (`seenDigit`, `seenExponent`, `seenDot`) to track state.

### **Time Complexity**: `O(n)`
- **Single-Pass**: The algorithm iterates through the input string exactly once, performing constant-time operations (like comparisons) for each character.
- **Constant-Time Checks**: Checking character types (e.g., `Character.isDigit` or comparing against specific characters) is performed in constant time for each character.

### **Space Complexity**: `O(1)`
- **Constant-Space Usage**: The algorithm only uses a fixed number of boolean variables (`seenDigit`, `seenExponent`, and `seenDot`) to track validation states, regardless of the input size.
- **No Additional Structures**: The input string is processed directly without requiring extra data structures, ensuring constant memory usage.