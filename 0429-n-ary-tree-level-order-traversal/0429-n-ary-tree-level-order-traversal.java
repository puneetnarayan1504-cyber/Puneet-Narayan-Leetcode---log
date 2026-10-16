/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Base case: if the tree is empty
        if (root == null) {
            return result;
        }
        
        // Use a queue to facilitate level-by-level traversal (BFS)
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                for (Node child : currentNode.children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            result.add(currentLevel);
        }
        
        return result;
    }
}