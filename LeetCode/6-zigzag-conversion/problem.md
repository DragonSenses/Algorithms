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

