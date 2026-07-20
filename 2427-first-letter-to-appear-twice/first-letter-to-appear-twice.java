class Solution {
    public char repeatedCharacter(String s) {
        HashSet<Character> result = new HashSet<>();
        for(char ch : s.toCharArray()){
            if(result.contains(ch)){
                return ch;
            }
            result.add(ch);

        }
        return ' ';
        
    }
}