// LeetCode 543 - Diameter of Binary Tree
// Pattern: DFS (Postorder Traversal / Tree DP)
// Time: O(n), Space: O(h) where h is the height of the tree

class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        findMax(root);
        return max;
    }

    private int findMax(TreeNode node){
        //base case
        if(node == null){
            return 0;
        }

        int lh = findMax(node.left);
        int rh = findMax(node.right);

        max = Math.max(max,lh + rh);

        return Math.max(lh,rh) + 1;
    }
}