/*
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
 

Constraints:

1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.
*/

class Solution {

    List<String> res;

    public List<String> letterCasePermutation(String S) {
        char[] chs = S.toCharArray();
        res = new ArrayList<>();

        recursive(chs, 0);

        return res;
    }

    public void recursive(char[] chs, int idx) {
        int len = chs.length;

        if (idx == len) {
            res.add(new String(chs));
            return;
        }

        if (!isAlpha(chs[idx])) {
            recursive(chs, idx + 1);
        } else {
            chs[idx] = Character.toLowerCase(chs[idx]);
            recursive(chs, idx + 1);
            chs[idx] = Character.toUpperCase(chs[idx]);
            recursive(chs, idx + 1);
        }
    }

    public boolean isAlpha(char ch) {
        int tmp = ch - 'a';
        if (tmp >= 0 && tmp <= 25) {
            return true;
        }

        tmp = ch - 'A';
        if (tmp >= 0 && tmp <= 25) {
            return true;
        }

        return false;
    }

}
