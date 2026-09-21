class Solution {
    public int firstUniqChar(String s) {
        int [] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) -'a']++;
        } 
        Queue<Integer> queue= new LinkedList<>();

        for(int i = 0; i < s.length(); i++){
            queue.offer(i);
        }
       while(!queue.isEmpty()){
          int index = queue.peek();
           if (freq[s.charAt(index) - 'a'] == 1) {
                return index;
            }
            queue.poll();
        }
        return -1;
    }
}