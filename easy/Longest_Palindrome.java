// LeetCode 409 - Longest Palindrome
// Pattern: Frequency Counting + Greedy
// Time: O(n), Space: O(1)

class Solution {
    public int longestPalindrome(String s) {

        int[] freq = new int[128]; // covers A-Z, a-z
        int length = 0;
        boolean hasOdd = false;

        // count frequency of each character
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        // build palindrome length
        for (int count : freq) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1; // In case of odd, use count - 1
                hasOdd = true;
            }
        }

        // one odd character can sit in the middle
        if (hasOdd) {
            length += 1;
        }

        return length;
    }
}
