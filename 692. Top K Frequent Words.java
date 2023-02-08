/*
Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
*/

class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    final int n = words.length;
    List<String> ans = new ArrayList<>();
    List<String>[] bucket = new List[n + 1];
    Map<String, Integer> count = new HashMap<>();

    for (final String word : words)
      count.put(word, count.getOrDefault(word, 0) + 1);

    for (final String word : count.keySet()) {
      final int freq = count.get(word);
      if (bucket[freq] == null)
        bucket[freq] = new ArrayList<>();
      bucket[freq].add(word);
    }

    for (int freq = n; freq > 0; --freq)
      if (bucket[freq] != null) {
        Collections.sort(bucket[freq]);
        for (final String word : bucket[freq]) {
          ans.add(word);
          if (ans.size() == k)
            return ans;
        }
      }

    throw new IllegalArgumentException();
  }
}
