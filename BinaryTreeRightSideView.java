// https://leetcode.com/problems/binary-tree-right-side-view/

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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> nodeList = new ArrayList<Integer>();
        if(root == null){
            return nodeList;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();
        TreeNode checkNode = new TreeNode(Integer.MAX_VALUE);
        TreeNode nodes = null;
        int vd = 0;

        nodeList.add(root.val);
        nodeQueue.add(checkNode);
        nodeQueue.add(root);
        nodeMap.put(vd, nodeList);

        while(nodeQueue.isEmpty() == false){
            nodes = nodeQueue.remove();
            if(nodes == checkNode){
                vd = vd + 1;
            }else{

                if(!nodeQueue.contains(checkNode)){
                    nodeQueue.add(checkNode);
                }

                if(nodes.left != null){
                    nodeQueue.add(nodes.left);
                    if(!nodeMap.containsKey(vd)){
                        nodeList = new ArrayList<>();
                        nodeList.add(nodes.left.val);
                        nodeMap.put(vd, nodeList);
                    }else{
                        nodeList = nodeMap.get(vd);
                        nodeList.add(nodes.left.val);
                        nodeMap.put(vd, nodeList);
                    }
                }
                if(nodes.right != null){
                    nodeQueue.add(nodes.right);
                    if(!nodeMap.containsKey(vd)){
                        nodeList = new ArrayList<>();
                        nodeList.add(nodes.right.val);
                        nodeMap.put(vd, nodeList);
                    }else{
                        nodeList = nodeMap.get(vd);
                        nodeList.add(nodes.right.val);
                        nodeMap.put(vd, nodeList);
                    }
                }

            }
        }

        // System.out.println(nodeMap);
        ArrayList<Integer> keysSorted = new ArrayList<Integer>(nodeMap.keySet());
        // Collections.sort(keysSorted);

        nodeList = new ArrayList<>();
        for(Integer i : keysSorted){
            ArrayList<Integer> sortedList = new ArrayList<Integer>(nodeMap.get(i));
            nodeList.add(sortedList.get(sortedList.size() - 1));
        }

        return nodeList;
    }
}