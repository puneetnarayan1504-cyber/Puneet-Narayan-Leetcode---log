class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map <String, List<String>> freqStrMap = new HashMap<>();
        for(String str : strs){
            String freqStr = getFrequencyString(str);
            if(freqStrMap.containsKey(freqStr)){
                freqStrMap.get(freqStr).add(str);
            }
            else{
                List<String> strList = new ArrayList<>();
                strList.add(str);
                freqStrMap.put(freqStr, strList);
            }
        }
        return new ArrayList<>(freqStrMap.values());
    }
    private String getFrequencyString(String str) {
        int[] count = new int[26]; 
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        StringBuilder freqStr = new StringBuilder("");
        char c = 'a';
        for(int i : count){
            freqStr.append(c);
            freqStr.append(i);
            c++;
        }
        return freqStr.toString();
    }
}