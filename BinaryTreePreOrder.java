// https://leetcode.com/problems/binary-tree-preorder-traversal/

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> printNodes = new ArrayList<>();
        if(root == null){
            return printNodes;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        TreeNode nodes = null;
        while(nodeStack.empty() == false){

            nodes = nodeStack.peek();
            printNodes.add(nodes.val);
            nodeStack.pop();

            if(nodes.right!=null){
                nodeStack.push(nodes.right);
            }
            if(nodes.left != null){
                nodeStack.push(nodes.left);
            }
        }
        return printNodes;
    }
}