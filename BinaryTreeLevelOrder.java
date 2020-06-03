// https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> node = new ArrayList<List<Integer>>();
        List<Integer> nodeInner = new ArrayList<>();

        if(root ==null){
            return node;
        }
        TreeNode nodes = null;
        TreeNode checkNode = null;
        Queue<TreeNode> queueNode = new LinkedList<>();
        queueNode.add(checkNode);
        queueNode.add(root);


        while(queueNode.size()!=0){
            nodes = queueNode.peek();
            if(nodes == checkNode){
                node.add(nodeInner);
                nodeInner = new ArrayList<>();
                queueNode.remove();
            }else{
                nodeInner.add(nodes.val);
                queueNode.remove();
                if(queueNode.contains(checkNode)==false){
                    queueNode.add(checkNode);
                }
                if(nodes.left!=null){
                    queueNode.add(nodes.left);
                }
                if(nodes.right!=null){
                    queueNode.add(nodes.right);
                }
            }
        }
        node.remove(0);
        return node;
    }
}