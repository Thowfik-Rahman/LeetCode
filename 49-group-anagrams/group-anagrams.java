class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String word : strs) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
            
           
            StringBuilder key = new StringBuilder();
            for (int num : count) {
                key.append('#').append(num);
            }
            String signature = key.toString();
            
            
            map.putIfAbsent(signature, new ArrayList<>());
            map.get(signature).add(word);
        }
        
        return new ArrayList<>(map.values());
    }
}
