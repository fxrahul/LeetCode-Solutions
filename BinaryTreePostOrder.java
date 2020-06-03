// https://leetcode.com/problems/binary-tree-postorder-traversal/

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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> nodeList = new ArrayList<Integer>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        if(root == null){
            return nodeList;
        }

        stack1.push(root);
        TreeNode nodes = null;
        while(stack1.isEmpty() == false){
            nodes = stack1.pop();
            stack2.push(nodes);
            if(nodes.left!=null){
                stack1.push(nodes.left);
            }
            if(nodes.right!=null){
                stack1.push(nodes.right);
            }
        }
        while(stack2.isEmpty() == false){
            nodeList.add(stack2.pop().val);
        }

        return nodeList;
    }
}