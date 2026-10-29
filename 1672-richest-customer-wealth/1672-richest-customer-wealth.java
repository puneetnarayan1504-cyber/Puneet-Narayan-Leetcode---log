class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] cust : accounts) {
            int currentWealth = 0;
            
            for (int bank : cust) {
                currentWealth += bank;
            }
            
            maxWealth = Math.max(maxWealth, currentWealth);
        }
        
        return maxWealth;
    }
}