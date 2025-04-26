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