class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        /*
Move right → add new characters

If duplicate found:
    Move left
    Remove characters
    Until duplicate disappears

Keep track of the largest window.
         */
        for(int right = 0; right < s.length(); right++){
            //t's a while loop because sometimes we need to remove more than one character before the duplicate disappears.
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
        
    }
}