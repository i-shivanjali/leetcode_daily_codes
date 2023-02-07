/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
*/

class Solution {
  public String decodeString(String s) {
    Stack<Pair<StringBuilder, Integer>> stack = new Stack<>(); // (prevStr, repeatCount)
    StringBuilder currStr = new StringBuilder();
    int currNum = 0;

    for (final char c : s.toCharArray())
      if (Character.isDigit(c)) {
        currNum = currNum * 10 + (c - '0');
      } else {
        if (c == '[') {
          stack.push(new Pair<>(currStr, currNum));
          currStr = new StringBuilder();
          currNum = 0;
        } else if (c == ']') {
          final Pair<StringBuilder, Integer> pair = stack.pop();
          final StringBuilder prevStr = pair.getKey();
          final int n = pair.getValue();
          currStr = prevStr.append(getRepeatedStr(currStr, n));
        } else {
          currStr.append(c);
        }
      }

    return currStr.toString();
  }

  // S * n times
  private StringBuilder getRepeatedStr(StringBuilder s, int n) {
    StringBuilder sb = new StringBuilder();
    while (n-- > 0)
      sb.append(s);
    return sb;
  }
}
