/*
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;

        Integer[] freq = countFreq(s1);
        int n = s2.length(), left = 0, right = 0;
        int count = s1.length();
        while (right < n) {
            char c = s2.charAt(right);
            // Verify and move right
            if (freq[c] == null) {// reset
                freq = countFreq(s1);
                left = ++right;
                count = s1.length();
                continue;
            }
            right++;
            count--;
            freq[c]--;
            
            // Move left when necessary
            while(freq[c] < 0) {
                freq[s2.charAt(left++)]++;
                count++;
            }
            
            // verify:
            if (count == 0) return true;
        }
        return count == 0;
    }
    
    private Integer[] countFreq(String s) {
        Integer[] freq = new Integer[256];
        for (char c : s.toCharArray()) freq[c] = freq[c] == null ? 1 : freq[c] + 1;
        return freq;
    }
}
