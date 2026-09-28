class Solution {
    public int maxDepth(String s) {
       int ans = 0;
        int x = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                x++;
                ans = Math.max(ans, x);
            } else if (c == ')') {
                x--;
            }
        }
        
        return ans;

    }
}