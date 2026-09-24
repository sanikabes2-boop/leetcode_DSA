import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) {
            return ans;
        }

        int[] freqP = new int[26];
        int[] freqS = new int[26];

        // Frequency of characters in p
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }

        // First window of s
        for (int i = 0; i < p.length(); i++) {
            freqS[s.charAt(i) - 'a']++;
        }

        // Sliding window
        for (int i = 0; i <= s.length() - p.length(); i++) {

            if (Arrays.equals(freqP, freqS)) {
                ans.add(i);
            }

            // Remove the character leaving the window
            if (i + p.length() < s.length()) {
                freqS[s.charAt(i) - 'a']--;
                
                // Add the new character
                freqS[s.charAt(i + p.length()) - 'a']++;
            }
        }

        return ans;
    }
}