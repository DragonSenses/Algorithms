# Zigzag Conversion

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```sh
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

  `string convert(string s, int numRows);`

#### Example 1:

Input: `s = "PAYPALISHIRING", numRows = 3`
Output: `"PAHNAPLSIIGYIR"`

#### Example 2:

Input: `s = "PAYPALISHIRING", numRows = 4`
Output: `"PINALSIGYAHRPI"`
Explanation:

```sh
P     I    N
A   L S  I G
Y A   H R
P     I
```

#### Example 3:

Input: `s = "A", numRows = 1`
Output: `"A"`

#### Constraints:

    1 <= s.length <= 1000
    s consists of English letters (lower-case and upper-case), ',' and '.'.
    1 <= numRows <= 1000

# Solution

### **Understanding the Problem**

Let's look at the input, output and process.

Input: `s = "PAYPALISHIRING", numRows = 4`
Output: `"PINALSIGYAHRPI"`
Process:
```sh
P     I    N
A   L S  I G
Y A   H R
P     I
```

#### **Observations**

We can see that given the number of rows we form a grid. Then we transform the string on the grid by moving downwards then diagonally to the top right.

After the string is formed in a zigzag manner on the grid, we read it row-by-row starting from the top to form the string.

The question we can ask is: *how many spots from the first character of the input string do we have to jump to get to the next character in the output string?* and *is there a formula/algorithm we can calculate that?*

Let's walk through example 2 to see the algorithm.

#### Calculate the first row

We start with `P` in the grid, then we have to move down `3` and move diagonally to the right `3` spots to get to `I`.

Notice that we have `4` rows so the amount of times we move is:

  - `4-1` rows downwards
  - `4-1` rows diagonally to the right

Meaning we move `(4-1) * 2` times to get to from the first character `P` to the next character in the output string `I`.

So we are moving `(numRows - 1) * 2` times, so in this case `(4-1)*2` = `(3)*2` = `6` times to get the first row.

`Grid replacing characters with number of spots to jump to the next character`
```sh
P     I    N
1   5 1  5 G
2 4   2 4
3     3
```

Now in the input string we can get the first row by adding the index by `6` starting at index 0. So the 3 characters are: `string[0] + string[0 + 6] + string[0 + 6 + 6]`.

Process: `string[0] + string[6] + string[12]`
Input: `s = "PAYPALISHIRING"`
Row 1: `PIN`

#### Calculate the second row

With the second row we start at index 1, `string[1]`. But how do we calculate the entire row? If we repeat the same process for the first row but this time starting at index 1 and adding `6`.

```sh
P     5    5
A   4 S  4 G
1 3   1 3
2     2
```
Process: `string[1] + string[7] + string[13]`
Input: `s = "PAYPALISHIRING"`
Row 1: `ASG`

But notice that row 2 consists of more than just 3 characters, we missed the characters in the 4th spot.

Why is this tricky? If we follow the "zigzags" and form groups:

group 1: PAYPAL
group 2: ISHIRI
group 3: NG

```sh
(P     (I     N
A   L)  S  I) G
Y A     H R
P       I
```

Notice the first row only has one character in each zigzag group: `P I N`.
In the second row, group 1 contains 2 characters in the zigzag: `AL` and group 2: `SI` with group 3: `G`
The third row will also have 2 characters in the zizag group, group 1: `YA`, group 2: `HR`, group 3: n/a
The last row is similar to the first row with only one character in a zizag group. group 1: `P` group 2: `I`

- For the first and last rows we can jump a certain number of times `(N-1)*2`, or `6` spots to get the transformed string row.
- Other rows (any row not the first or last) will also take `6` spots, but we need to ensure that we catch the intermediate characters found in the same row within the zigzag groups

##### Find the intermediate characters in the zigzag groups

  - *Note*: that we only need to do this for the rows middle rows (rows that are *not* the first or last).

**How to get the intermediate characters in the zigzag group?**

Depends on the row number but for each row away from the first we subtract 2 to the formula `(N-1)*2`. 

To see how we need to first append the grid with the row numbers:

`Grid with row numbers:`
```sh
0 P     I    N
1 A   L S  I G
2 Y A   H R
3 P     I
```

Remember the formula: `(N-1) * 2` 

With `4` rows:
- 1st Row `(N-1)*2` = `(4-1)*2 = 6` spots to jump to next character
- 2nd Row also `6 spots` to jump to get *a* character
  - To get intermediate characters we need to subtract `2`, so `((4-1)*2) - 2` = `4` spots to jump
- 3rd Row - `6 spots`, and `6 - 2 - 2` spots for intermediate characters

```sh
P     5    5
A   4 S  4 G
1 3   1 3
2     2
```

So from this we can create the formula to calculate intermediate characters in a zigzag group:

`[(N-1) * 2] - 2r`
  - `N` is number of total rows
  - `r` is number of rows away from the first

#### Calculate the third row

```sh
P     4    4
A   3 5  3 5
Y 2   H 2
1     1
```

- Intermediate characters
  - `[(N-1) * 2] - 2r`
  - `[6] - 2(2)` = `2`
- Next character
  - `(N-1) * 2`
  - `6`

#### One row input

If the input has only one row, return the input string as is; no transformation or conversion is needed.

## Java

```java
class Solution {
  public String convert(String s, int numRows) {
    // Edge case: null input or invalid indices
    if (s == null || numRows < 1) {
      return "";
    }

    // Edge case: Single row
    if (numRows == 1) {
      return s;
    }
    
    StringBuilder output = new StringBuilder();

    // Create the zigzag increment with formula: 2 * (numRows - 1)
    int increment = 2 * (numRows - 1);

    // Iterate through each row
    for (int row = 0; row < numRows; row++) {
      // Create the string for each row
      for (int i = row; i < s.length(); i += increment) {
        // Add the character at the current index
        output.append(s.charAt(i));

        // Add intermediate characters for middle rows
        if (row > 0 && row < numRows - 1 
          && i + increment - 2*row < s.length()) {
            output.append(s.charAt(i + increment - 2*row));
        }
      }
    }

    return output.toString();
  }
}
```
