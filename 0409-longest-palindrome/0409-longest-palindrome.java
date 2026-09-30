class Solution {
    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];
        int maxLength = 0;
        boolean hasOddCount = false;

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i)]++;
        }

        for (int count : charCounts) {
            maxLength += (count / 2) * 2;
            
            if (count % 2 == 1) {
                hasOddCount = true;
            }
        }

        if (hasOddCount) {
            maxLength++;
        }

        return maxLength;
    }
}