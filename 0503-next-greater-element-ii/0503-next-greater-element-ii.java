class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int i = 0; i < 2 * n; i++) {
            int currIndex = i % n;
            
            while (!stack.isEmpty() && nums[stack.peek()] < nums[currIndex]) {
                res[stack.pop()] = nums[currIndex];
            }
            
            if (i < n) {
                stack.push(currIndex);
            }
        }
        
        return res;
    }
}