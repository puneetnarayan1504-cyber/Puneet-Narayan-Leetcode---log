/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int postorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeRecursively(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursively(int[] postorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int rootValue = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootValue);
        postorderIndex--;

        int rootIndexInorder = inorderIndexMap.get(rootValue);

        root.right = buildTreeRecursively(postorder, rootIndexInorder + 1, right);
        
        root.left = buildTreeRecursively(postorder, left, rootIndexInorder - 1);

        return root;
    }
}