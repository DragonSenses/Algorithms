# Valid Parentheses

Given a string s containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

#### Example 1:

Input: s = "()"

Output: true

#### Example 2:

Input: s = "()[]{}"

Output: true

#### Example 3:

Input: s = "(]"

Output: false

#### Example 4:

Input: s = "([])"

Output: true

#### Constraints:

  - `1 <= s.length <= 10^4`
  - `s` consists of parentheses only `'()[]{}'`.

# Solution

## Stacks

### **Intuition**

Let's carefully read the problem statement to understand what makes an input string **valid**:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket must have a corresponding open bracket of the same type.

We also know that the input string only contains these characters: `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`.

To simplify the problem, let's consider a model where the string only consists of one type of parenthesis `()` and check whether it is valid or not:

```sh
# Valid cases
()          # Valid
()()        # Valid
(())        # Valid
(()())      # Valid
(((())))    # Valid

# Invalid cases
((          # Invalid
())         # Invalid
(()         # Invalid
)()(        # Invalid
(()))       # Invalid
```
