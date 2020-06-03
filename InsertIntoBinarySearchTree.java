// https://leetcode.com/problems/insert-into-a-binary-search-tree/

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode copyRoot = root;
        if(root == null){
            TreeNode newNode = new TreeNode(val);
            root = newNode;
            return root;
        }
        TreeNode previousRoot = null;
        while(root!=null){
            previousRoot = root;
            if(val > root.val){
                root = root.right;
            }else{
                root = root.left;
            }
        }
        TreeNode newNode = new TreeNode(val);
        if(val > previousRoot.val){
            previousRoot.right = newNode;
        }else{
            previousRoot.left = newNode;
        }

        return copyRoot;

    }
}