// LeetCode 1161 - Maximum Level Sum of a Binary Tree
// Pattern: BFS / Level Order Traversal
// Time: O(n), Space: O(n)

class Solution {
    public int maxLevelSum(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int maxSum = Integer.MIN_VALUE; // same as INT_MIN in the image
        int maxSumLevel = 1;

        int level = 1;

        while (!q.isEmpty()) {
            int sum = 0;               // reset sum for this level
            int n = q.size();          // number of nodes at this level

            while (n-- > 0) {
                TreeNode curr = q.poll();
                sum += curr.val;

                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                maxSumLevel = level;
            }

            level++;
        }

        return maxSumLevel;
    }
}
