// https://leetcode.com/problems/validate-binary-search-tree/
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
    // huge node traversal
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        if( leftSideLess(root.left, root.val) && rightSideGreater(root.right, root.val) &&                isValidBST(root.left) && isValidBST(root.right) ){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean leftSideLess(TreeNode root, int val){
        if(root == null){
            return true;
        }
        if( root.val < val  && leftSideLess(root.left, val) && leftSideLess(root.right, val) )         {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean rightSideGreater(TreeNode root, int val){
        if(root == null){
            return true;
        }
        if( root.val > val  && rightSideGreater(root.left, val) &&                                        rightSideGreater(root.right, val) ){
            return true;
        }
        else{
            return false;
        }
    }

    //less node traversal

//     public boolean isValidBST(TreeNode root) {
//         return checkBSTAlias(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//     }

//     public boolean checkBSTAlias(TreeNode root, int minVal, int maxVal){
//         if(root == null){
//             return true;
//         }
//         if(root.val < maxVal && root.val > minVal && 
//            checkBSTAlias(root.left, minVal, root.val)
//            && checkBSTAlias(root.right, root.val, maxVal))
//         {
//             return true;
//         }else{
//             return false;
//         }
//     }
}