// https://leetcode.com/problems/binary-tree-inorder-traversal/

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> printNodes = new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<>();

        if(root == null){
            return printNodes;
        }
        TreeNode nodes = root;
        while(nodes != null || nodeStack.isEmpty() == false){
            while(nodes!=null){ // for left traversal
                nodeStack.push(nodes);
                nodes = nodes.left;
            }

            nodes = nodeStack.pop();
            printNodes.add(nodes.val);// store root
            nodes = nodes.right; // for right traversal
        }
        return printNodes;

    }
}