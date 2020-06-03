// https://leetcode.com/problems/maximum-depth-of-binary-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        int h1 = 0;
        int h2  =0;
        if(root == null){
            return 0;
        }
        h1 = maxDepth(root.left);
        h2 = maxDepth(root.right);

        return Math.max(h1,h2)+1;

    }
}