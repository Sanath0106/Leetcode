// LeetCode 1411 - Number of Ways to Paint N × 3 Grid
// Pattern: Dynamic Programming (State Compression)
// Time: O(n), Space: O(1)

class Solution {
    static final int MOD = 1_000_000_007;

    public int numOfWays(int n) {

        // type2: patterns like ABA (first and third same)
        // type3: patterns like ABC (all different)
        long type2 = 6;
        long type3 = 6;

        for (int i = 2; i <= n; i++) {
            long newType2 = (type2 * 3 + type3 * 2) % MOD;
            long newType3 = (type2 * 2 + type3 * 2) % MOD;

            type2 = newType2;
            type3 = newType3;
        }

        return (int)((type2 + type3) % MOD);
    }
}
