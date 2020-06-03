// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

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
        //iterative approach
//         if(root == null){
//             return root;
//         }
//         TreeNode copyRoot = root;
//         ArrayList<TreeNode> list = new ArrayList<>();
//         ArrayList<TreeNode> list2 = new ArrayList<>();

//         while(root.val != p.val){
//             if(p.val < root.val){
//                 list.add(root);
//                 root = root.left;
//             }else{
//                 list.add(root);
//                 root = root.right;
//             }
//         }
//         list.add(root);
//         root = copyRoot;
//         while(root.val != q.val){
//             if(q.val < root.val){
//                 list2.add(root);
//                 root = root.left;

//             }else{
//                 list2.add(root);
//                 root = root.right;

//             }
//         }
//         list2.add(root);

//         if(list.size() != 0 && list2.size() != 0){
//             if(list.size() >= list2.size()){
//                 list.retainAll(list2);
//                 root = list.get(list.size() - 1);
//             }else{
//                 list2.retainAll(list);
//                 root = list2.get(list2.size() - 1);
//             }
//         }else{
//             if(list.size() == 0){
//                 root = list2.get(list2.size() - 1);
//             }else{
//                 root = list.get(list.size() - 1);
//             }
//         }

//         return root;

        //iterative approach 2

        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else{
                break;
            }
        }
        return root;
    }
}