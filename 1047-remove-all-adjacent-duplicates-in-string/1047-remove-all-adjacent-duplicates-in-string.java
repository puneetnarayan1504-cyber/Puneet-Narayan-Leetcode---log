 class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
             
            if (!deque.isEmpty() && deque.peekLast() == c) {
                deque.pollLast(); 
            } else {
                deque.offerLast(c);  
            }
        }
        
        int size = deque.size();
        char[] result = new char[size];
        for (int i = 0; i < size; i++) {
            result[i] = deque.pollFirst(); 
        }
        
        return new String(result);
    }
}