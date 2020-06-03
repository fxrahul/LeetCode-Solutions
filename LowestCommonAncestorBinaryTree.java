// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Stack<TreeNode> nodeStack = new Stack<>();
        // while(root ! =null || nodeStack.isEmpty() == false){
        //     while(root!=null){
        //         nodeStack.push(root);
        //         root = root.left;
        //     }
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        leftNode = lowestCommonAncestor(root.left,p,q);
        rightNode= lowestCommonAncestor(root.right,p,q);

        if(leftNode != null && rightNode != null){
            return root;
        }else{
            if(leftNode != null){
                return leftNode;
            }else{
                return rightNode;
            }

        }
    }
}
