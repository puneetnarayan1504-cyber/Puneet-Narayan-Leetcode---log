class Solution {
    public int lastStoneWeight(int[] stones) {
      PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());

      for(int stone : stones){
        PQ.add(stone);
        
      }
      while(PQ.size()>1){
        int max1 = PQ.remove();
        int max2 = PQ.remove();
        if(max1 != max2){
            PQ.add(max1 - max2);
        }
      }
      return PQ.isEmpty() ? 0 : PQ.remove();
    }
}