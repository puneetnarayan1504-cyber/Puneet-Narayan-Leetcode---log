class Solution {
    public int smallestIndex(int[] nums) {
        int i;
        for(i=0;i<nums.length;i++){
            int x=nums[i];
            int sum=0;
            while(x!=0){            
                
                sum+=x%10;
                x/=10;
            }
            if(sum==i){
                return i;
            }
        }
        return -1;
    }
}