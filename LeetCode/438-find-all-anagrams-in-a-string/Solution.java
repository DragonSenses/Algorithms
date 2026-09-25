class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> result = new ArrayList<>();
    if (s.length() < p.length())
      return result;

    int[] pCount = new int[26];
    int[] windowCount = new int[26];

  }
}
