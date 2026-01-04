// LeetCode 1390 – Four Divisors
// Pattern: Math + Brute Force (Divisor Counting up to √n)
// Time: O(n * √m), Space: O(1)

class Solution {
    private int sumOfDivisorsIfFour(int num) {
        int count = 0;
        int sum = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                int other = num / i;

                if (i == other) {      // perfect square
                    count += 1;
                    sum += i;
                } else {
                    count += 2;
                    sum += i + other;
                }

                // early exit if more than 4 divisors
                if (count > 4) return 0;
            }
        }

        return count == 4 ? sum : 0;
    }

    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result += sumOfDivisorsIfFour(num);
        }
        
        return result;
    }
}
