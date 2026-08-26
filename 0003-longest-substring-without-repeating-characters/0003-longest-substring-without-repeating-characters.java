class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen=0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();

                while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLen= Math.max(maxLen,set.size());
                right++;

            }
            else{
                set.remove(s.charAt(left));
                left++;
            }

        }
        return maxLen;
    }
}