// LeetCode 1339 - Maximum Product of Splitted Binary Tree
// Pattern: DFS (Postorder Traversal)
// Time: O(n), Space: O(h) where h is height of tree

class Solution {

    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {

        //Find total sum of the tree
        totalSum = getTotalSum(root);

        //DFS again to compute max product
        getSubtreeSum(root);

        return (int)(maxProduct % MOD);
    }

    // DFS to calculate total sum
    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;

        return node.val 
             + getTotalSum(node.left) 
             + getTotalSum(node.right);
    }

    // DFS to calculate subtree sums and max product
    private long getSubtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = getSubtreeSum(node.left);
        long right = getSubtreeSum(node.right);

        long subtreeSum = node.val + left + right;

        long product = subtreeSum * (totalSum - subtreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subtreeSum;
    }
}
