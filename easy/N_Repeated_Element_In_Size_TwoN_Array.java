// LeetCode 961 - N-Repeated Element in Size 2N Array
// Pattern: Duplicate Detection using HashSet
// Time: O(n), Space: O(n)

import java.util.HashSet;

class Solution {
    public int repeatedNTimes(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }
}
