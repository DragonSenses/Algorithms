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

#### Counter-based approach

Let's form a simple algorithm to match this problem.

1. **Process the expression one bracket at a time starting from the left.**
2. **Encountering an opening bracket** `(` may or may not indicate an invalid expression because there can be a matching ending bracket somewhere in the remaining part of the expression.
   - **Increment the counter** keeping track of left parenthesis: `left += 1`
3. **If we encounter a closing bracket**, this has two meanings:
   - There was no matching opening bracket for this closing bracket, and in that case, we have an invalid expression. This is the case when `left == 0`, i.e., when there are no unmatched left brackets available.
   - We had some **unmatched** opening bracket available to match this closing bracket. This is the case when `left > 0`, i.e., we have unmatched left brackets available.
4. **If we encounter a closing bracket** `)` when `left == 0`, then we have an invalid expression. Otherwise, **we decrement `left`**, thus reducing the number of unmatched left parenthesis available.
5. **Continue processing the string** until all parentheses have been processed.
6. **In the end, if we still have unmatched left parenthesis available**, this implies an invalid expression.

