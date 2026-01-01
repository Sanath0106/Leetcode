// LeetCode 66 - Plus One
// Pattern: Carry Propagation
// Time: O(n), Space: O(1)

class Solution {
    public int[] plusOne(int[] digits) {

        int len = digits.length;
        int i = len - 1;

        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // digit is 9 → becomes 0, carry continue
            digits[i] = 0;
            i--;
        }

        // all digits were 9
        int[] result = new int[len + 1];
        result[0] = 1;
        return result;
    }
}
