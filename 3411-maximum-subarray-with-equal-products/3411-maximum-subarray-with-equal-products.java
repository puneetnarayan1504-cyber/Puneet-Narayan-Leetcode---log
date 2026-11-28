class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            long prod = 1;
            int gcdVal = 0;
            long lcmVal = 1;

            for (int j = i; j < n; j++) {
                int x = nums[j];
                prod *= x;
                gcdVal = (j == i) ? x : gcd(gcdVal, x);
                lcmVal = lcm(lcmVal, x);

                if (prod > 2520L * gcdVal) {
                    break;
                }

                if (prod == lcmVal * gcdVal) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long gcdLong(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcdLong(a, b)) * b;
    } 
}
