class Solution {
    public double myPow(double x, int n) {
        long nn = n; 
    
        if (nn < 0) {
            nn = -nn;
        }
        
        double ans = 1.0;
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
            }
            x = x * x;
            nn = nn / 2;
        }
        if (n < 0) {
            return 1.0 / ans;
        }
        
        return ans;
    }
}